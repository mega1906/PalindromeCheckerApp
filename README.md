# PalindromeCheckerApp

### Use Case 11: Object‑Oriented Palindrome Service

This program checks whether a string is a palindrome using an **encapsulated service class**.  
`PalindromeService` hides the implementation and exposes a simple method: `isPalindrome(String)`.

- **Encapsulation** – logic lives in a dedicated class  
- **Separation of concerns** – UI (main) vs. service (logic)  
- **Reusability** – call the service anywhere

## How to Run
```bash
javac com/palindromechecker/UseCaseElevenPalindromeChecker.java
java com.palindromechecker.UseCaseElevenPalindromeChecker