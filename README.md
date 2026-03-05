# PalindromeCheckerApp

### Use Case 6: Queue + Stack Palindrome Checker

This program checks whether a string is a palindrome by using **two data structures at the same time**:

- a **Queue** (FIFO)
- a **Stack** (LIFO)

Each character is added into both structures.  
Then the program removes characters from the **front of the queue** and the **top of the stack** and compares them.  
If everything matches, the string is a palindrome.

## How to Run
```bash
javac com/palindromechecker/UseCaseSixPalindromeChecker.java
java com.palindromechecker.UseCaseSixPalindromeChecker