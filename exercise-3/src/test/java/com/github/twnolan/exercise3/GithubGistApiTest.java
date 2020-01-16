package com.github.twnolan.exercise3;

import com.github.twnolan.exercise3.utils.FileOperationsManager;
import com.github.twnolan.exercise3.utils.FileOperationsManagerImpl;
import com.github.twnolan.exercise3.utils.PropertiesReader;
import com.github.twnolan.exercise3.utils.PropertiesReaderImpl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import java.util.Properties;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GithubGistApiTest {
  private static FileOperationsManager fileOperationsManager;
  private static final String BASE_URL = "https://api.github.com";
  private static String accessToken;
  private static String username;

  @BeforeAll
  public static void setUp() {
    PropertiesReader propertiesReader = new PropertiesReaderImpl();
    Properties properties = propertiesReader.getPropertiesFromFile("user.properties");
    fileOperationsManager = new FileOperationsManagerImpl();
    username = properties.getProperty("username");
    accessToken = properties.getProperty("accessToken");
  }

  @Test
  @Tag("gist-api-test")
  @Order(1)
  public void createCallCreatesGist() {
    String requestPayload = "{\n\"description\": \"API Test Gist\",\n\"public\": true,\n\"files\": {\n\"automated_test.txt\": {\n\"content\": \"Gist created via automated test\"\n}\n}\n}";
    String postRequestPath = String.format("%s/gists", BASE_URL);

    String gistId = given()
      .auth().preemptive().oauth2(accessToken)
      .contentType(ContentType.JSON)
      .body(requestPayload)
    .when()
      .post(postRequestPath)
    .then()
      .contentType("application/json")
      .body("description", equalTo("API Test Gist"))
      .body("files.\"automated_test.txt\".filename", equalTo("automated_test.txt"))
      .body("files.\"automated_test.txt\".type", equalTo("text/plain"))
      .body("files.\"automated_test.txt\".language", equalTo("Text"))
      .body("files.\"automated_test.txt\".content", equalTo("Gist created via automated test"))
      .body("owner.login", equalTo(username))
      .statusCode(201)
      .statusLine("HTTP/1.1 201 Created")
    .extract()
      .path("id");

    fileOperationsManager.writeToTextFile(gistId);
  }

  @Test
  @Tag("gist-api-test")
  @Order(2)
  public void listCallReturnsAllFieldsSpecifiedInDocumentation() {
    String listUsersGistsPath = String.format("%1$s/users/%2$s/gists", BASE_URL, username);

    Response response = given()
      .auth().preemptive().oauth2(accessToken)
    .when()
      .get(listUsersGistsPath)
    .then()
      .statusCode(200)
      .statusLine("HTTP/1.1 200 OK")
    .extract()
      .response();

    //TODO - create schema, check versus schema
  }

  @Test
  @Tag("gist-api-test")
  @Order(3)
  public void deleteCallDeletesGist() {
    String gistId = fileOperationsManager.readInputFile();
    String deleteRequestPath = String.format("%1$s/gists/%2$s", BASE_URL, gistId);

    given()
      .auth().preemptive().oauth2(accessToken)
    .when()
      .delete(deleteRequestPath)
    .then()
      .statusCode(204)
      .statusLine("HTTP/1.1 204 No Content");
  }
}
