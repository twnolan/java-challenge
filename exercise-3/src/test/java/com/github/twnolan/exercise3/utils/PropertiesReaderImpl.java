package com.github.twnolan.exercise3.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReaderImpl implements PropertiesReader{

  @Override
  public Properties getPropertiesFromFile(String filename) {
    Properties properties = new Properties();

    try (InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(filename)) {

      if (inputStream == null) {
        System.out.println("No properties file found");
        return null;
      }

      properties.load(inputStream);

      // properties.getProperty("username");
      // properties.getProperty("accessToken");
    } catch (IOException error) {
      error.printStackTrace();
    }

    return properties;
  }
}
