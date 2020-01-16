package com.github.twnolan.exercise1;

import java.util.List;

public class EvaluateFile {

  public static void main(String[] args) {
    FileOperationsManager fileOperationsManager = new FileOperationsManagerImpl();
    LineEvaluator lineEvaluator = new LineEvaluatorImpl();
    String fileName = args[0];

    List<String> fileLines = fileOperationsManager.readInputFile(fileName);
    List<String> outputLines = lineEvaluator.evaluateLines(fileName, fileLines);
    fileOperationsManager.writeToLogFile(outputLines);
  }
}
