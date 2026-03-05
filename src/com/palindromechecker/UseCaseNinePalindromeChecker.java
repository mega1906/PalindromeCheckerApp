package com.palindromechecker;

import java.util.*;

/*
 * Use Case 9: Recursive Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using recursion.
 *
 * Characters are compared from the outer positions
 * moving inward using recursive calls.
 *
 * The recursion stops when:
 *  - All characters are matched, or
 *  - A mismatch is found.
 *
 * This use case demonstrates divide-and-conquer
 * logic using method recursion.
 *
 * @author Developer
 * @version 9.0
 */

public class UseCaseNinePalindromeChecker {
	/*
	 * Application entry point for UC9.
	 *
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		String input = sc.nextLine();
		System.out.println("Is Palindrome? : "+ isPalindrome(input, 0, input.length() - 1));
	}

	/*
	 * Recursively checks whether a string is palindrome.
	 *
	 * @param s     Input string
	 * @param start Starting index
	 * @param end   Ending index
	 * @return true if palindrome, otherwise false
	 */
	private static boolean isPalindrome(String s, int start, int end) {
		if (start >= end) return true; 
		if (s.charAt(start) != s.charAt(end)) return false;
		
		return isPalindrome(s, start + 1, end - 1);
	}
}
