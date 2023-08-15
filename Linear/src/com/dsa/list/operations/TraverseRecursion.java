package com.dsa.list.operations;

import java.util.Scanner;
import java.util.function.Consumer;

public class TraverseRecursion {

	static Scanner scanner = new Scanner(System.in);
	static Node<Object> node;
	static Node<Object> start;
	static Node<Object> currentNode;
	static Consumer<Object> print = s -> System.out.println(s);

	public static void main(String[] args) {
		while (true) {
			showOptions();
		}
	}

	private static void showOptions() {
		System.out.println(
				"Please select option: \n 1. Create List \n 2. Add Elements to List \n 3. Show Records using Recursion");
		int option = scanner.nextInt();
		switch (option) {
		case 1:
			createList();	
			break;
		case 2:
			addElements();
			break;
		case 3:
			showRecordsUsingRecursion(start);
			break;
		default:
			System.exit(0);
			break;
		}
	}
	
	private static void showRecordsUsingRecursion(Node<Object> node) {
		if (node != null) {
			System.out.println(node.data);
		}
		if(node.next!=null)
			showRecordsUsingRecursion(node.next);
	}

	public static void createList() {
		Object data = readData();		
		if(start == null) {
			node = new Node<>(data, null);
			start = node;
			currentNode = node;
		}
	}
	
	private static Object readData() {
		print.accept("Please enter element value:\n");
		Object data = null;
		if (scanner.hasNext()) {
			data = scanner.next();
		}
		return data;
	}
	
	public static void addElements() {
		if(start == null) {
			print.accept("List does not exist, please create list first");
			return;
		}
		Object data = readData();
		addElementAtPosition(data, null);
	}
	
	private static void addElementAtPosition(Object data, Node<Object> positionNode) {
		Node<Object> node = new Node<>(data, positionNode);
		currentNode.next = node;
		currentNode = node;
	}
}
