package com.palindromechecker;

import java.util.Scanner;
import java.util.Stack;

/*
 * Use Case 5: Stack Based Palindrome Checker
 * 
 * Description:
 * This class validated a palindrome using a stack
 * data structure which follows the LIFO principle
 * 
 * At this stage, the application:
 * - Pushes characters into a stack
 * - Pops them in reverse order
 * - Compares with original sequence
 * - Displays the result
 * 
 * This map stack behavior to reversal logic
 * 
 * @author Developer
 * @version 5.0
 */

public class UseCaseFivePalindromeChecker {
	/*
	 * Application entry point for UC5
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		String input = sc.nextLine();
		System.out.println("Is Palindrome? : "+ isPalindrome(input));
	}
	public static boolean isPalindrome(String s) {
		// Create a stack to store the characters
		Stack<Character> stack = new Stack<>();
		
		// Convert the string to char array
		char[] input = s.toCharArray();
		
		// Push each character of the string into a stack
		for (char i : input) {
			stack.push(i);
		}
		
		// Assume palindrome initially
		boolean ispalindrome = true;
		
		// Iterate again through the original string 
		for (int i = 0; i < s.length(); i++) {
			// Compare character at i with the character at the top of the stack
			if (s.charAt(i) != stack.pop()) {
				ispalindrome = false;
				return false;
			}
		}
		return true;
				
	}
}
