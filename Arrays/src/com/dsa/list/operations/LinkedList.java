package com.dsa.list.operations;

import java.util.Scanner;
import java.util.function.Consumer;

public class LinkedList {

	static Scanner scanner = new Scanner(System.in);
	static int index = 0;
	static Node<Object> node;
	static Node<Object> start;
	static Node<Object> currentNode;
	static Consumer<Object> print = s -> System.out.println(s);

	public static void main(String[] args) {
		while(true)
			showOptions();
	}

	public static void showOptions() {
		int input = 0;
		print.accept("\n Selection Options \n" + "1: Create List \n" + "2: Add Element \n"
				+ "3: Delete Element \n" + "4: Search Element \n" + "5: Add Element at the begining of the list \n"
				+ "6: Add Element at the end of the list\n" + "7: Show Elements \n" + "8: Exit");
		if(scanner.hasNextInt()) {
			input = scanner.nextInt();
		}
		switch (input) {
		case 1:
			createList();
			break;
		case 2:
			addElements();
			break;
		case 3:
			deleteElement();
			break;
		case 4:
			searchElement();
			break;
		case 5:
			addAtBegining();
			break;
		case 6:
			addAtTheEnd();
			break;
		case 7:
			showElements();
			break;	
		default:
			System.exit(0);
		}
	}

	public static void addElements() {
		if(start == null) {
			print.accept("List does not exist, please create list first");
			return;
		}
		Object data = readData();
		addElementAtPosition(data, null);
	}

	public static void addAtBegining() {
		Object data = readData();
		Node<Object> node = new Node<>(data, start);
		start = node;
	}

	public static void addAtTheEnd() {
		Object data = readData();
		addElementAtPosition(data, null);
	}

	private static Object readData() {
		print.accept("Please enter element value:\n");
		Object data = null;
		if (scanner.hasNext()) {
			data = scanner.next();
		}
		return data;
	}

	private static void addElementAtPosition(Object data, Node<Object> positionNode) {
		Node<Object> node = new Node<>(data, positionNode);
		currentNode.next = node;
		currentNode = node;
	}

	public static void createList() {
		Object data = readData();		
		if(start == null) {
			node = new Node<>(data, null);
			start = node;
			currentNode = node;
		}
	}

	public static void showElements() {
		if (null != start) {
			Node<Object> itrNode = start;
			while (true) {
				print.accept(itrNode.data);
				if (itrNode.next == null) {
					break;
				}
				itrNode = itrNode.next;
			}
		}
	}

	public static void searchElement() {
		print.accept("Please enter element value to search");
		Object data = null;
		if (scanner.hasNext()) {
			data = scanner.next();
		}		
		Node<Object> node = searchElement(start, data);
		if(node != start) {
			print.accept("Search Element Found");
		}else {
			print.accept("Search Element does not exist in the list");
		}
	}

	private static Node<Object> searchElement(Node<Object> start, Object data) {
		if (null != start) {
			Node<Object> itrNode = start;
			while (true) {
				if (itrNode.data.equals(data)) {
					return itrNode;
				}
				itrNode = itrNode.next;
			}
		}
		return start;
	}

	public static void deleteElement() {
		print.accept("Please enter element value to Delete from list");
		Object data = null;
		Node<Object> prevNode = start;
		if (scanner.hasNext()) {
			data = scanner.next();
		}
		if (null != start) {
			Node<Object> nextNode = start;
			while (true) {
				
				if(nextNode.next == null && nextNode.data.equals(data)) {
					start = currentNode = null;
					break;
				}
				
				if(prevNode.data.equals(data)) {
					prevNode = prevNode.next;
					start = prevNode;
					break;
				}
				
				if (prevNode.next !=null && prevNode.next.data.equals(data)) {
					nextNode = prevNode.next.next;
					prevNode.next = nextNode;
					break;
							
				}
				prevNode = prevNode.next;
			}
		}
	}
}
