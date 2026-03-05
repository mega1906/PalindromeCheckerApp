package com.palindromechecker;

import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/*
 * UC8: Linked List Based Palindrome Checker App
 * 
 * Description:
 * This class checks whether a string is a palindrome
 * using a LinkedList.
 * 
 * Characters are added to the list and then compared 
 * by removing elements from both ends:
 * 
 * - removeFirst()
 * - removeLast()
 * 
 * This demonstrates how LinkedList supports
 * double-ended operation for symmetric validation.
 * 
 * @author Developer
 * @version 8.0
 */

public class UseCaseEightPalindromeChecker {
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

		// Create a LinkedList to store characters
		LinkedList<Character> list = new LinkedList<>();
		
		// Insert each character into the linked list
		for (char c : input) {
			list.add(c);
		}

		// Flag to track palindrome status
		boolean ispalindrome = true;

		// Compare characters until the linkedlist becomes empty
		while (list.size() > 1) { 
			if (list.removeFirst() != list.removeLast()) {
				ispalindrome = false;
				return ispalindrome;
			}
		}
		return ispalindrome;
	}

}
