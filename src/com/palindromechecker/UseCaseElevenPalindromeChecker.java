package com.palindromechecker;

import java.util.ArrayDeque;
import java.util.Scanner;

/*
 * Use Case 11: Object Oriented Palindrome Service
 * 
 * Description:
 * This class demonstrates palindrome validation using
 * object-oriented design.
 * 
 * The palindrome logic is encapsulated inside a
 * PalindromeService class
 * 
 * This improves:
 * - Reusability
 * - Readability
 * - Separation of concerns
 * 
 * @author Developer
 * @version 11.0
 */

public class UseCaseElevenPalindromeChecker {
	/**
	 * Application entry point for UC10.
	 *
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		String input = sc.nextLine();
		
		PalindromeService service = new PalindromeService();
		
		System.out.println("Is Palindrome? : "+ service.isPalindrome(input));
	}
}

/*
 * Service class that contains palindrome logic
 */
class PalindromeService {
	/*
	 * Checks whether the input string is a palindrome
	 * 
	 * @param input Input string
	 * @return true if palindrome, false otherwise
	 */
	public boolean isPalindrome(String s) {
		if (s == null) return false;

		String normalized = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		ArrayDeque<Character> stack = new ArrayDeque<>();

		for (char c : normalized.toCharArray()) stack.push(c);

		for (int i = 0; i < normalized.length(); i++) {
			if (normalized.charAt(i) != stack.pop()) return false;
		}
		return true;

	}
}
