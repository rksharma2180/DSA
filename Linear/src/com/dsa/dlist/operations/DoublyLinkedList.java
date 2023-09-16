package com.dsa.dlist.operations;

import java.util.Scanner;
import java.util.function.Consumer;

public class DoublyLinkedList {

	static Scanner scanner = new Scanner(System.in);
	static Node<Integer> head;
	static Node<Integer> currentNode;
	static Consumer<Object> print = s -> System.out.print(s);

	public static void main(String[] args) {
		while(true) {
			showOptions();
		}
	}

	public static void showOptions() {
		int input = 0;
		print.accept("\n Selection Options \n" + "1: Create List \n" + "2: Add Element \n"
				+ "3: Delete Element \n" + "4: Search Element \n" + "5: Add Element at the begining of the list \n"
				+ "6: Add Element at the end of the list\n" + "7: Show Elements \n" + "8: Show Reverse List \n" 
				+ "9: Reverse List \n 10: Exit");
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
		case 8:
			printReverseList();
			break;
		case 9:
			reverseList();
			break;
		default:
			System.exit(0);
		}
	}

	private static void reverseList() {
		Node<Integer> temp = head;
		while(temp != currentNode) {
			Node<Integer> ptr = temp.next;
			temp.next = currentNode.next;
			temp.prev = currentNode;
			if (currentNode.next !=null) 
				currentNode.next.prev = temp;
			currentNode.next = temp;
			temp.prev = currentNode;
			temp = ptr;
		}
		temp = head;
		head = currentNode;
		currentNode = temp;
	}

	private static void printReverseList() {
		Node<Integer> temp = currentNode;
		do {
			print.accept(temp.data+"<-->");
			temp = temp.prev;
		} while(temp.prev !=null);
		print.accept(head.data);
	}

	private static void showElements() {
		Node<Integer> temp = head;
		if(temp != null) {
			while(temp.next != null) {
				print.accept(temp.data + "<-->");
				temp = temp.next;
			}
			print.accept("" + currentNode.data + "->"+currentNode.next);
		} else {
			print.accept("List is empty");
		}
	}

	private static void addAtTheEnd() {
		addElements();
	}

	private static void addAtBegining() {
		print.accept("Enter Element");
		int element = scanner.nextInt();
		Node<Integer> temp = new Node<>(element, head, null);
		head = temp;
	}

	private static void searchElement() {
		print.accept("Enter Element");
		int element = scanner.nextInt();
		Node<Integer> node = findNode(head, element);
		if (null != node) {
			print.accept("Element found");
			return;
		}
		print.accept("Element not found");
	}

	private static void deleteElement() {
		print.accept("Enter Element");
		int element = scanner.nextInt();
		Node<Integer> node = findNode(head, element);
		if (null != node) {
			if(node != head)
				node.prev.next = node.next;
			else 
				head = node.next;
			print.accept("Element Deleted Successfully " + node.data);
		}
	}

	private static Node<Integer> findNode(Node<Integer> head, Integer element){
		Node<Integer> temp = head;
		do {
			if (temp.data.equals(element)) {
				return temp;
			}
			temp = temp.next;
		} while (temp.next != null);
		return null;
	}

	private static void addElements() {
		print.accept("Enter Element");
		int element = scanner.nextInt();
		Node<Integer> temp = new Node<>(element, null, currentNode);
		currentNode.next = temp;
		currentNode = temp;
	}

	private static void createList() {
		print.accept("Enter First Element");
		int element = scanner.nextInt();
		head = currentNode = new Node<>(element, null, null);
	}
}