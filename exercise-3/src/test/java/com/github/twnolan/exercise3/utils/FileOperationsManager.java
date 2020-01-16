package com.github.twnolan.exercise3.utils;

import java.util.List;

public interface FileOperationsManager {

  /**
   * Read the input from a file
   *
   * @return - single line
   */
  public String readInputFile();

  /**
   * Write output to file
   *
   * @param outputLine - line to output to file
   */
  public void writeToTextFile(String outputLine);
}
