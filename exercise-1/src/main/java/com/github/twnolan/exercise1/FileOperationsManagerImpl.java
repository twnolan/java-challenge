package com.github.twnolan.exercise1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manager for reading and writing to files operations
 */
public class FileOperationsManagerImpl implements FileOperationsManager {

  public FileOperationsManagerImpl() {
  }

  public List<String> readInputFile(String fileName) {
    List<String> fullInput = new ArrayList<>();

    try {
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      String inputLine;

      while ((inputLine = bufferedReader.readLine()) != null) {
        fullInput.add(inputLine);
      }

      fileReader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return fullInput;
  }

  public void writeToLogFile(List<String> outputList) {
    try {
      FileWriter fileWriter = new FileWriter("test_result.log", true);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

      for (String outputLine : outputList) {
        bufferedWriter.write(outputLine);
        bufferedWriter.newLine();
      }

      bufferedWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
