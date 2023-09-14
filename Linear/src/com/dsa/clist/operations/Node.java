package com.dsa.clist.operations;

public class Node<T> {

	T data;
	Node<T> next;

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public Node(T data) {
		this.data = data;
	}

	public static Node<Object> add(Node<Object> start, Object data) {
		Node<Object> newNode = new Node<Object>(data);
		if (start == null) {
			start = newNode;
			start.next = start;
		} else {
			Node<Object> temp = start;
			while (temp.next != start) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.next = start;
		}
		return newNode;
	}

	public static void showRecord(Node<Object> start) {
		Node<Object> temp = start;
		if(temp != null) {
			do {
				System.out.print(temp+ "->");
				temp = temp.next;
			}
			while(temp != start);
		}
		else {
			System.out.println("List is empty.");
		}
	}
	
	@Override
	public String toString() {
		return this.data.toString();
	}

	public static void addAtTheEnd(Object element, Node<Object> head, Node<Object> tail) {
		if (element !=null) {
			Node<Object> node = new Node<>(element);
			tail.next = node;
			node.next = head;
			tail = node;
		}
	}

	public static void addAtTheBegining(Object element, Node<Object> head, Node<Object> tail) {
		if (element !=null) {
			Node<Object> node = new Node<>(element);
			node.next = head;
			tail.next = node;
			head = node;
		}
	}
}
