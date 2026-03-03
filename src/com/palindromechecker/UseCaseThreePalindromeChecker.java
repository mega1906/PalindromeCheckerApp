package com.palindromechecker;
 
import java.util.Scanner;
 
/*
*
* Use Case 3: Reverse String Based Palindrome Check
*
* Description:
* This class checks whether a string is a palindrome
* by reversing the string and comparing it with
* the original value.
*
* At this stage, the application:
* - Iterates the string in reverse order
* - Builds a reversed version
* - Compares original and reversed strings
* - Displays the validation result
*
* This introduces transformation-based validation.
*
* @author Developer
* @version 3.0
*/
public class UseCaseThreePalindromeChecker {
    /*
     * Application entry point for UC3.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Input text : ");
    	String input=sc.nextLine();
        String reversed = "";
 
        // Iterate from the last character to the first.
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
 
        if (input.equals(reversed)) {
            System.out.println("Is it a palindrome? : true");
        } 
        else {
            System.out.println("Is it a palindrome? : false");
        }
    }
}