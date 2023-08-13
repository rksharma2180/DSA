package com.dsa.dlist.operations;

import java.util.Scanner;
import java.util.function.Consumer;

import com.dsa.list.operations.Node;

public class DoublyLinkedList {
	
	static Scanner scanner = new Scanner(System.in);
	static Node<Object> node;
	static Node<Object> start;
	static Node<Object> currentNode;
	static Consumer<Object> print = s -> System.out.println(s);
	
	public static void main(String[] args) {
		
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
}
