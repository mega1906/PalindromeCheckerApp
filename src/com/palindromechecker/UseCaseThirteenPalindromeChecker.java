package com.palindromechecker;

import java.util.*;

/*
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * At this stage, the application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses purely on performance
 * measurement and algorithm comparison.
 *
 * The goal is to introduce benchmarking concepts.
 *
 * @author Developer
 * @version 13.0
 */

public class UseCaseThirteenPalindromeChecker {
	/*
	 * Application entry point for UC13.
	 *
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		String input = sc.nextLine();

		// Prepare both strategies
		PalindromeStrategy stack = new StackStrategy();
		PalindromeStrategy deque = new DequeStrategy();

		// StackStrategy timing
		long t1 = System.nanoTime();
		boolean stackResult = stack.check(input);
		long t2 = System.nanoTime();
		long stackTime = t2 - t1;

		// DequeStrategy timing
		long t3 = System.nanoTime();
		boolean dequeResult = deque.check(input);
		long t4 = System.nanoTime();
		long dequeTime = t4 - t3;

		System.out.println();
		System.out.println("Performance");
		System.out.println(stack.name() + " -> Result: " + stackResult + " | Time: " + stackTime + " ns");
		System.out.println(deque.name() + " -> Result: " + dequeResult + " | Time: " + dequeTime + " ns");
	}
}

/*
 * ==============================================================
 * INTERFACE – PalindromeStrategy
 * ==============================================================
 *
 * This interface defines a contract for all palindrome
 * checking algorithms.
 *
 * Any new algorithm must implement this interface
 * and provide its own validation logic.
 */
interface PalindromeStrategy { 
	/**
	 * @param input raw input string
	 * @return true if palindrome according to this strategy, else false
	 */
	boolean check(String input);

	/** Human-friendly name for logging/display. */
	default String name() {
		return getClass().getSimpleName();
	}

	/** Common normalization for all strategies. */
	default String normalize(String s) {
		if (s == null) return null;
		// Keep only letters/digits; lowercase.
		return s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
	}
}

/*
 * ==============================================================
 * CLASS – ClassStrategy
 * ==============================================================
 *
 * This class provides a Stack-based implementation
 * of the PalindromeStrategy interface.
 *
 * It uses LIFO behavior to reverse characters
 * and compare them with the original sequence.
 */
class StackStrategy implements PalindromeStrategy {
	@Override
	public boolean check(String input) {
		if (input == null) return false;

		String normalized = normalize(input);
		if (normalized == null) return false; 

		ArrayDeque<Character> stack = new ArrayDeque<>();

		// Push all characters
		for (char c : normalized.toCharArray()) {
			stack.push(c);
		}

		// Compare original vs reversed via pop
		for (int i = 0; i < normalized.length(); i++) {
			if (normalized.charAt(i) != stack.pop()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String name() {
		return "StackStrategy (LIFO mirror)";
	}
}


class DequeStrategy implements PalindromeStrategy {

	@Override
	public boolean check(String input) {
		if (input == null) return false;

		String normalized = normalize(input);
		if (normalized == null) return false;

		// Push all characters
		Deque<Character> deque = new ArrayDeque<>();
		for (char c : normalized.toCharArray()) {
			deque.addLast(c);
		}

		// Compare original by removing from deque
		while (deque.size() > 1) {
			if (!deque.removeFirst().equals(deque.removeLast())) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String name() {
		return "DequeStrategy (bidirectional compare)";
	}
}

