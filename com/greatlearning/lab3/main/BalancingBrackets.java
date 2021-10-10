package com.greatlearning.lab3.main;

import java.util.Stack;

public class BalancingBrackets {

	public static boolean isBalanced(String bracketExpression) {
		Stack<Character> bs = new Stack<Character>();

		// Traversing the Expression
		for (int i = 0; i < bracketExpression.length(); i++) {
			Character ch = bracketExpression.charAt(i);
			// Checking if the character is an open bracket
			if (ch == '(' || ch == '[' || ch == '{') {
				// Push the element in the stack
				bs.push(ch);
				continue;
			}
			// If current character is closing bracket
			// then check if stack is Empty or not
			if (bs.isEmpty())
				return false;
			Character c;
			switch (ch) {
			// if character is ')' then
			// top of the stack cannot be '{' or '['
			case ')':
				c = (Character) bs.pop();
				if (c == '{' || c == '[')
					return false;
				break;
			// if character is '}' then
			// top of the stack cannot be '(' or '['
			case '}':
				c = (Character) bs.pop();
				if (c == '(' || c == '[')
					return false;
				break;
			// if character is ']' then
			// top of the stack cannot be '(' or '{'
			case ']':
				c = (Character) bs.pop();
				if (c == '(' || c == '{')
					return false;
				break;
			}
		}
		// Check if Stack is Empty
		return (bs.isEmpty());

	}

	public static void main(String[] args) {
		String bracketExpression = "([[{}]])";
		// Calling the Method to check if the expression is balanced or not
		if (isBalanced(bracketExpression))
			System.out.println("Bracket Expression is Balanced ");
		else
			System.out.println("Bracket Expression is Not Balanced ");
	}

}
