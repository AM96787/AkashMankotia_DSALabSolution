package com.greatlearning.lab3.main;

import java.util.ArrayList;

public class LongestPath {
	// Node of a Binary tree
	static class Node {
		Node left;
		Node right;
		int data;
	}

	// New Binary Node Creation Method
	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = node.right = null;
		return node;
	}

	private static ArrayList<Integer> getLongestPath(Node root) {
		// If root is null
		// return an empty ArrayList
		if (root == null) {
			ArrayList<Integer> longestPath = new ArrayList<>();
			return longestPath;
		}
		// Recursive call on root.right
		ArrayList<Integer> right = getLongestPath(root.right);
		// Recursive call on root.left
		ArrayList<Integer> left = getLongestPath(root.left);
		// Compare the size of the left and right ArrayList
		// and insert current node to left or right
		if (right.size() < left.size()) {
			left.add(root.data);
		} else {
			right.add(root.data);
		}
		// Return the appropriate ArrayList
		return (left.size() > right.size() ? left : right);
	}

	public static void main(String[] args) {
		// Insert the elements in the tree 
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);
		ArrayList<Integer> longestPath = getLongestPath(root);
		int size = longestPath.size() - 1;
		// This will print the Longest Path
		for (int i = size; i >= 0; i--) {
			System.out.print(longestPath.get(i));
			if (i > 0)
				System.out.print(" -> ");
		}

	}

}
