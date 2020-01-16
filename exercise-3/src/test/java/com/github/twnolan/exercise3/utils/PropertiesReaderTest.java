package com.github.twnolan.exercise3.utils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class PropertiesReaderTest {
  private static PropertiesReader propertiesReader;

  @BeforeAll
  public static void setUp() {
    propertiesReader = new PropertiesReaderImpl();
  }

  @Test
  @Tag("PropertiesReaderTests")
  public void nonExistentFileNameReturnsNull() {
    Properties properties = propertiesReader.getPropertiesFromFile("bad_filename.properties");
    assertNull(properties, "Properties should be null");
  }

  @Test
  @Tag("PropertiesReaderTests")
  public void returnsAllProperties() {
    Properties properties = propertiesReader.getPropertiesFromFile("example.properties");
    assertNotNull(properties, "Properties should be present");
    assertEquals("username", properties.getProperty("username"));
    assertEquals("my_secret_access_token", properties.getProperty("accessToken"));
  }
}
