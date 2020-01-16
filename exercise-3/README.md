# Exercise-3

API tests against github's gist API using java 8 and rest-assured

### Requirements

```
Java 8+ (Developed using openjdk version "1.8.0_222")
Maven 3 (Developed using version 3.7.0)
```

### Before Running the Tests

In the folder `/src/test/java/resources` create a new file called 
`user.properites` with the same keys as the `example.properties` file provided 
in the same folder.  Change the values to the desired github username and github 
access token. 

### To Run Tests

Note: For minimal setup and in order to prevent accidental deletion of data, 
`deleteCallDeletesGist` test depends on an output file from `createCallCreatesGist` 
test.  Tests are ordered to run in a specific order to avoid an error from 
running `deleteCallDeletesGist` when `createCallCreatesGist` has not been run.

To run all tests:

```bash
mvn test
```  

To run only GithubGistApiTests:

```bash
 mvn -Dgroups="gist-api-test" test
```