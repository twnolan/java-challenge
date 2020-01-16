package com.github.twnolan.exercise1;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to evaluate each line of input and produce corresponding lines of
 * output on the corresponding rules
 */
public class LineEvaluatorImpl implements LineEvaluator {
  public LineEvaluatorImpl() {

  }

  public List<String> evaluateLines(String fileName, List<String> fileLines) {
    boolean isLimitError = false;
    List<String> outputLines = new ArrayList<>();

    for (String line : fileLines) {
      String[] lineParts = line.split("\t", 2);
      String lineNumber = lineParts[0];
      int lineValue = Integer.parseInt(lineParts[1].trim());

      if (!greaterThanOrEqualTo100(lineValue)) {
        outputLines.add(lessThan100ErrorMessage(lineNumber, lineValue));
        isLimitError = true;
        continue;
      }

      if (!lessThanOrEqualTo500(lineValue)) {
        outputLines.add(greaterThan500ErrorMessage(lineNumber, lineValue));
        isLimitError = true;
      }
    }

    if (isLimitError) {
      outputLines.add(0, String.format("%s: Fail", fileName));
    } else {
      outputLines.add(String.format("%s: Pass", fileName));
    }

    return outputLines;
  }

  /**
   * Check if a number is greater than or equal to 100
   *
   * @param number - number to evaluate
   * @return - true or false
   */
  private boolean greaterThanOrEqualTo100(int number) {
    return number >= 100;
  }

  /**
   * Check if a number is less than or equal to 500
   *
   * @param number - number to evaluate
   * @return - true or false
   */
  private boolean lessThanOrEqualTo500(int number) {
    return number <= 500;
  }

  /**
   * Generate the error message for line whose number is less than 100
   *
   * @param lineNumber - the line number of the file
   * @param value - the value associated with the line number
   * @return - formatted error message
   */
  private String lessThan100ErrorMessage(String lineNumber, int value) {
    return String.format("Line %s: %d is less than 100!", lineNumber, value);
  }

  /**
   * Generate the error message for line whose number is greater than 500
   *
   * @param lineNumber - the line number of the file
   * @param value - the value associated with the line number
   * @return - formatted error message
   */
  private String greaterThan500ErrorMessage(String lineNumber, int value) {
    return String.format("Line %s: %d is greater than 500!", lineNumber, value);
  }
}
