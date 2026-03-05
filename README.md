# PalindromeCheckerApp

### Use Case 7: Deque-Based Optimized Palindrome Checker

This program checks whether a string is a palindrome using a **Deque (Double‑Ended Queue)**.  
Instead of reversing the string, characters are added to a deque and compared from **both ends** using `removeFirst()` and `removeLast()`.  
This gives a simple and efficient front‑to‑back comparison.

## How to Run
```bash
javac com/palindromechecker/UseCaseSevenPalindromeChecker.java
java com.palindromechecker.UseCaseSevenPalindromeChecker