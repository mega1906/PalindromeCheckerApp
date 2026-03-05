package com.palindromechecker;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

/*
 * Use Case 7: Deque Based Optimized Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using a Deque
 * (Double Ended Queue).
 *
 * Characters are inserted into the deque and then
 * compared by removing elements from both ends:
 *
 *   - removeFirst()
 *   - removeLast()
 *
 * This avoids reversing the string and provides an
 * efficient front-to-back comparison approach.
 *
 * This use case demonstrates optimal bidirectional
 * traversal using Deque.
 *
 * @author Developer
 * @version 7.0
 */

public class UseCaseSevenPalindromeChecker {
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
		char[] input = s.toCharArray();

		// Create a Deque to store characters
		Deque<Character> deque = new ArrayDeque<>();

		// Add each character to the deque
		for (char c : input) { 
			deque.addLast(c);
		}

		// Flag to track palindrome result
		boolean ispalindrome = true;

		// Continue comparison while more than one element exists
		while (deque.size() > 1) { 
			if (deque.removeFirst() != deque.removeLast()) {
				ispalindrome = false;
				return ispalindrome;
			}
		}
		return ispalindrome;

	}
}
