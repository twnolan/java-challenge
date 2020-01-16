# Exercise 1 – Code practice

Program to evaluate a file consisting of line number and value pairs and check 
if the value is between 100 and 500.  Results of whether it passes or fails and 
details of any failure will be produced in the following formats:

```
random_numbers.txt: Pass
```

```
random_numbers_with_errors.txt: Fail
Line 1: -15 is less than 100!
Line 2: 0 is less than 100!
Line 3: 99 is less than 100!
Line 7: 501 is greater than 500!
Line 8: 779 is greater than 500!
```

Results will be created in a new file called `test_results.log` if this file 
does not exist, or appended to the existing results if the file exists.

### Requirements

```
Java 8+ (Developed using openjdk version "1.8.0_222")
Maven 3 (Developed using version 3.7.0)
```

### Run program with provided example files

Compile the program by running:

```bash
mvn compile
```

To run the program against a set of data that is known to pass, run the 
following command:

```bash
mvn exec:java -Dexec.mainClass=com.github.twnolan.exercise1.EvaluateFile -Dexec.args="random_numbers.txt"
```

To run the program against a set of data that is known to produce failures, run 
the following command:

```bash
mvn exec:java -Dexec.mainClass=com.github.twnolan.exercise1.EvaluateFile -Dexec.args="random_numbers_with_errors.txt"
```

### Run program with custom file

Create or copy the file to the root folder of the 'exercise-1' project then run
the following command, changing `<insert_filename>` to the filename to use

```bash
mvn exec:java -Dexec.mainClass=com.github.twnolan.exercise1.EvaluateFile -Dexec.args="<insert_filename>.txt"
```