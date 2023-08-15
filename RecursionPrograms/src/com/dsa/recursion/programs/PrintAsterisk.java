package com.dsa.recursion.programs;

import java.util.Scanner;

public class PrintAsterisk {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter number");
		int limit = sc.nextInt();
		printLine(limit);
	}

	public static void printLine(int n) {
		if (n > 0) {
			printLine(n - 1);
			printAsterisk(n);
			System.out.println("");
		}
	}
	
	public static void printAsterisk(int n) {
		if(n > 0) {
			printAsterisk(n-1);
			System.out.print("*");
		}
	}
}