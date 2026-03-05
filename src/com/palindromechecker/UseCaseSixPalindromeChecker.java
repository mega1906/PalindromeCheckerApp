package com.palindromechecker;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

/*
 * Use Case 6: Queue + Stack Fairness Check
 *
 * Description:
 * This class demonstrates palindrome validation using
 * two different data structures:
 *
 *  - Queue (FIFO – First In First Out)
 *  - Stack (LIFO – Last In First Out)
 *
 * Characters are inserted into both structures and then
 * compared by removing from the front of the queue and
 * the top of the stack.
 *
 * If all characters match, the input string is confirmed
 * as a palindrome.
 *
 * This use case helps understand how FIFO and LIFO
 * behaviors can be combined for symmetric comparison.
 *
 * @author Developer
 * @version 6.0
 */

public class UseCaseSixPalindromeChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		String input = sc.nextLine();
		System.out.println("Is Palindrome? : "+ isPalindrome(input));
	}
	public static boolean isPalindrome(String s) {
		char[] input = s.toCharArray();
		
		// Create a Queue to store characters in FIFO order
		Queue<Character> queue = new LinkedList<>();

		// Create a Stack to store characters in LIFO order
		Stack<Character> stack = new Stack<>();

		// Insert each character into both queue and stack
		for (char c : input) {
			queue.add(c);
			stack.push(c);
		}

		// Flag to track palindrome status
		boolean ispalindrome = true;

		// Compare characters until the queue becomes empty
		while (!queue.isEmpty()) { 
			if (queue.remove() != stack.pop()) {
				ispalindrome = false;
				return ispalindrome;
			}
		}
		return ispalindrome;
	}
}
