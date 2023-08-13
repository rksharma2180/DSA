package com.dsa.recursion.programs;

import java.util.Scanner;

public class Number {
	
	static Scanner sc = new Scanner(System.in);
	static int i = 1;
	static int limit = 0;
	public static void main(String[] args) {
		System.out.print("Enter limit to print from 1");
		limit = sc.nextInt();
		printNumbers();
	}
	private static void printNumbers() {
		System.out.print(i++ +",");
		if(i <= limit)
			printNumbers();
	}
}
