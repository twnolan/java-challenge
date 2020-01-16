package com.github.twnolan.exercise1;

import java.util.List;

public interface FileOperationsManager {

  /**
   * Read the input from a file
   *
   * @param fileName - the file name to read
   * @return - list of file lines
   */
  public List<String> readInputFile(String fileName);

  /**
   * Write output to 'test_result.log' file
   *
   * @param outputList - list of lines to output
   */
  public void writeToLogFile(List<String> outputList);
}
