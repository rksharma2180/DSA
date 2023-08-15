package com.dsa.recursion.programs;

import java.util.Scanner;

public class PrintAsteriskReverse {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter limit");
		int limit = sc.nextInt();
		printLine(limit);
	}
	
	public static void printLine(int n) {
		if(n>0) {
			System.out.println("");
			printnAsterisk(n);
			printLine(n-1);
		}
	}

	private static void printnAsterisk(int n) {
		if(n>0) {
			System.out.print("*");
			printnAsterisk(n-1);
		}
	}
}
