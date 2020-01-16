package com.github.twnolan.exercise1;

import java.util.List;

public interface LineEvaluator {

  /**
   * Evaluate each file line and produce lines for output file
   *
   * @param fileName - name of the input file
   * @param fileLines - list of input files lines
   * @return - list of lines to output to log file
   */
  public List<String> evaluateLines(String fileName, List<String> fileLines);
}
