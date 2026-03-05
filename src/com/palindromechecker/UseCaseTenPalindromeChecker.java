package com.palindromechecker;

import java.util.Scanner;

/*
 * Use Case 10: Normalized Palindrome Validation
 *
 * Description:
 * This class validates a palindrome after preprocessing
 * the input string.
 *
 * Normalization includes:
 *  - Removing spaces and symbols
 *  - Converting to lowercase
 *
 * This ensures the palindrome check is logical rather
 * than character-format dependent.
 *
 * Example:
 *  "A man a plan a canal Panama"
 *
 * @author Developer
 * @version 10.0
 */

public class UseCaseTenPalindromeChecker {
	/**
	 * Application entry point for UC10.
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
		String normalized = s.replaceAll("\\s+", "").toLowerCase();
		
		// Compare characters from both ends
		for (int i = 0; i < normalized.length() / 2; i++) {
			// Compare symmetric characters
			if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
