package com.github.twnolan.exercise3.utils;

import java.io.*;

/**
 * Manager for reading and writing to files operations
 */
public class FileOperationsManagerImpl implements FileOperationsManager {

  public FileOperationsManagerImpl() {
  }

  public String readInputFile() {
    StringBuilder fullInput = new StringBuilder();

    try {
      FileReader fileReader = new FileReader("target/test_output.txt");
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String inputLine;

      while ((inputLine = bufferedReader.readLine()) != null) {
        fullInput.append(inputLine);
      }

      fileReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return fullInput.toString();
  }

  public void writeToTextFile(String outputLine) {
    try {
      FileWriter fileWriter = new FileWriter("target/test_output.txt");
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      bufferedWriter.write(outputLine);
      bufferedWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
