package com.dsa.dlist.operations;

public class Node<T> {

	T data;
	Node<T> next = null;
	Node<T> prev = null;

	public Node(T data, Node<T> next, Node<T> prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}
}
