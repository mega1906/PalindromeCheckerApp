# PalindromeCheckerApp

### Use Case 12: Strategy Pattern for Palindrome Algorithms (Advanced)

This program demonstrates how different palindrome algorithms can be chosen **at runtime** using the Strategy Design Pattern.  
Two strategies are provided:

- **StackStrategy** → Uses a LIFO stack to mirror characters  
- **DequeStrategy** → Compares characters from both ends using a deque  

The user selects which strategy to run, showing how algorithms can be swapped without modifying the main logic.

## How to Run
```bash
javac com/palindromechecker/UseCaseTwelvePalindromeChecker.java
java com.palindromechecker.UseCaseTwelvePalindromeChecker