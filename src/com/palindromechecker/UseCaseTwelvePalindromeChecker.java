package com.palindromechecker;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack-based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * No performance comparison is done in this use case.
 * The focus is purely on algorithm interchangeability.
 *
 * The goal is to teach extensible algorithm design.
 *
 * @author Developer
 * @version 12.0
 */

public class UseCaseTwelvePalindromeChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input: ");
		String input = sc.nextLine();

		System.out.print("Choose algorithm [1=Stack, 2=Deque] (default 1): ");
		String choice = sc.nextLine().trim();

		PalindromeStrategy strategy = "2".equals(choice)
				? new DequeStrategy()
						: new StackStrategy();

		boolean result = strategy.check(input);
		System.out.println("Strategy: " + strategy.name());
		System.out.println("Is Palindrome? : " + result);
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

