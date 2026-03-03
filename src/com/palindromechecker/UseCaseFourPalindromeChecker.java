package com.palindromechecker;

import java.util.Scanner;

/*
 * Use Case 4: Character Array Based Validation
 *
 * Description:
 * This class validates a palindrome by converting
 * the string into a character array and comparing
 * characters using the two-pointer technique.
 *
 * At this stage, the application:
 * - Converts string to char array
 * - Uses start and end pointers
 * - Compares characters efficiently
 * - Displays the result
 *
 * This reduces extra memory usage.
 *
 * @author Developer
 * @version 4.0
 */

public class UseCaseFourPalindromeChecker {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		String input = sc.nextLine();
		System.out.println("Is Palindrome? : "+ isPalindrome(input));
		
	}
	public static boolean isPalindrome(String s) {
		int start = 0;
		int end = s.length()-1;
		char[] chars = s.toCharArray();
		while(start<end) {
			if(chars[start]!=chars[end]) return false;
			start++;
			end--;
		}
		return true;
	}
}