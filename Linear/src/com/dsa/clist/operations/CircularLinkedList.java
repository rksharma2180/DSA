package com.dsa.clist.operations;

import java.util.Scanner;
import java.util.function.Consumer;

public class CircularLinkedList {

	public static Node<Object> head = null;
	public static Node<Object> tail = null;
	static Scanner scanner = new Scanner(System.in);
	static Consumer<Object> print = s -> System.out.println(s);

	public static void main(String[] args) {
		while (true)
			showOptions();
	}

	public static void showOptions() {
		int input = 0;
		print.accept("\n Selection Options \n" + "1: Create List \n" + "2: Add Element \n" + "3: Delete Element \n"
				+ "4: Search Element \n" + "5: Add Element at the begining of the list \n"
				+ "6: Add Element at the end of the list\n" + "7: Show Elements \n" + "8: Show Reverse List \n"
				+ "9: Reverse List \n10: Delete First Element \n11: Delete Last Element \n12: Exit");
		if (scanner.hasNextInt()) {
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
			addAtTheBegining();
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
		case 10:
			deleteFirst();
			break;
		case 11:
			deleteLast();
			break;
		default:
			System.exit(0);
		}
	}

	private static void reverseList() {
		Node<Object> ptr = head;
		while (ptr != tail) {
			Node<Object> temp = ptr.next;
			ptr.next = tail.next;
			tail.next = ptr;
			ptr = temp;
		}
		head.next = tail;
		tail = head;
		head = ptr;
	}

	private static boolean isEmpty() {
		return head == null;
	}

	private static void printReverseList() {
		print.accept(tail.data);
		printReverse(head);
	}

	private static void printReverse(Node<Object> head) {
		Node<Object> ptr = head;
		if(ptr != tail) {
			printReverse(ptr.next);
			print.accept(ptr.data);
		}
	}

	private static void addAtTheBegining() {
		System.out.println("Enter element");
		Object element = scanner.next();
		if (element != null) {
			Node<Object> node = new Node<>(element);
			tail.next = node;
			node.next = head;
			head = node;
		}
	}

	private static void addAtTheEnd() {
		System.out.println("Enter element");
		Object element = scanner.next();
		if (element != null) {
			Node<Object> node = new Node<>(element);
			tail.next = node;
			node.next = head;
			tail = node;
		}
	}

	private static Node<Object> searchElement() {
		System.out.println("Enter element");
		Object element = scanner.next();
		if (element != null && head != null) {
			if (head.data.equals(element)) {
				System.out.println("Element Found at Head");
				return head;
			}

			if (tail.data.equals(element)) {
				System.out.println("Element Found at Tail");
				return tail;
			}

			Node<Object> ptr = head;
			int index = 0;
			while (ptr.next != head) {
				if (ptr.data.equals(element)) {
					System.out.println("Element Found at index " + index);
					return ptr;
				}
				ptr = ptr.next;
				index++;
			}
			System.out.println("Element does not exist in the list");
		}
		return null;
	}

	private static void deleteElement() {
		System.out.println("Enter element");
		Object data = scanner.next();
		if (!isEmpty() && data != null) {
			// if element exist in head
			if (head.data.equals(data)) {
				if (head == tail) {
					head = tail = null;
				} else if (head.next == tail){
					head = tail;
					tail.next = head;
				}else {
					tail.next = head.next;
				}
				print.accept("2 Element deleted from head successfully.");
				return;
			}

			// when only 2 elements present in the list
			if (head.next == tail) {
				if (tail.data.equals(data)) {
					tail = head;
					tail.next = head;
					print.accept("3 Element deleted from tail successfully.");
					return;
				}
			}

			Node<Object> ptr = head.next;
			Node<Object> prevPtr = head;
			do {
				if (ptr.data.equals(data)) {
					prevPtr.next = ptr.next;
					if(ptr == tail) {
						tail = prevPtr;
					}
					print.accept("4 Element deleted successfully");
					break;
				}
				prevPtr = ptr;
				ptr = ptr.next;
			} while (ptr != head);
		} else
			print.accept("List is Empty");
	}

	private static void deleteFirst() {
		if (isEmpty()) {
			print.accept("List is empty");
			return;
		}

		if (head == tail) {
			head = tail = null;
			return;
		}

		tail.next = head.next;
		head = head.next;
		print.accept("First element deleted");
	}

	private static void deleteLast() {
		if (isEmpty()) {
			print.accept("List is empty");
			return;
		}

		if (head == tail) {
			head = tail = null;
			return;
		}

		Node<Object> prevNode = head;
		while (prevNode.next != tail) {
			prevNode = prevNode.next;
		}
		prevNode.next = head;
		tail = prevNode;
		print.accept("Last Element deleted");
	}

	private static void showElements() {
		if (isEmpty()) {
			print.accept("List is empty.");
			return;
		}
		Node.showRecord(head);
		print.accept("\nHead " + head.data);
		print.accept("\nTail " + tail.data);
		print.accept("\nTail Next " + tail.next.data);
	}

	private static void addElements() {
		System.out.println("Enter element");
		Object data = scanner.next();
		if (head != null) {
			if (data != null) {
				tail = Node.add(head, data);
			}
		} else {
			print.accept("List is empty, please create list first");
		}
	}

	private static void createList() {
		System.out.println("Enter first element");
		Object data = scanner.next();
		if (data != null) {
			head = Node.add(null, data); // Not a good practice cause every time add will return same reference of start
											// node
			tail = head;
		}
		// Alternative approach is to use inner classes in this class
	}
}
