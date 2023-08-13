package com.dsa.recursion.programs;

import java.util.Scanner;

public class ReverseNumber {
	static Scanner sc = new Scanner(System.in);
	static int limit = 0;
	public static void main(String[] args) {
		System.out.print("Enter limit to print from");
		limit = sc.nextInt();
		printReverseNumbers();
	}
	private static void printReverseNumbers() {
		System.out.print(limit-- + ",");
		if(limit >= 1)
			printReverseNumbers();
	}
}
