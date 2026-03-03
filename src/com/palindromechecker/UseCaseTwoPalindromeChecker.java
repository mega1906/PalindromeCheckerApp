package com.palindromechecker;
 
import java.util.Scanner;
/*
* Use Case 2: Hardcoded Palindrome Validation
*
* Description:
* Demonstrates basic palindrome validation using a hardcoded string.
*
* Functionality:
* - Stores a predefined string
* - Compares characters from both ends
* - Determines whether the string is a palindrome
* - Displays the result on the console
*
* Purpose:
* Introduces fundamental comparison logic before using advanced data structures.
*
* Author: Developer
* Version: 2.0
*/

public class UseCaseTwoPalindromeChecker {
    /*
     * Application entry point for UC2.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Input text : ");
    	String input=sc.nextLine();
        boolean isPalindrome = true;
 
        // Loop only till half of the string length.
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length()-1-i)) {
                isPalindrome = false;
                break;
            }
        }
 
        if (isPalindrome) {
            System.out.println("Is it a palindrome? : true");
        } 
        else {
            System.out.println("Is it a palindrome? : false");
        }
    }
}