# Exercise 1 – Code practice

Exercise 1 – Code practice (approx. 2h) 
You have to test a program that generates 50 lines. Each line consists of 2 
numbers: line number and a random number, separated by a tab. Each random 
number (n) is ranging in value such that 100 <= n <= 500. For example: 
 
```
random_numbers.txt:  
1  315
2  289
3  109
4  500
...  
```

Task  
Write a test program in Java that takes a single command line argument, 
filename of the file to be parsed (random_numbers.txt) and verifies that the 
output satisfies the conditions stated above. Each testcase result should be 
written into a .log file by giving testcase a descriptive name and display it 
along with a Pass or a Fail result next to it, based on your validation. For 
failures, display every failure encountered on the next line(s) (if more than 1).  
 
 
 
For example: 
Having a test_results.log that contains:
```
TestCase1: Pass 
TestCase2: Fail  
Line <lineNumber>: Value <errorMessage> 
Line <lineNumber >: Value <errorMessage> 
Line < lineNumber >: Value <errorMessage> 
...  
TestCase3: Pass
``` 
