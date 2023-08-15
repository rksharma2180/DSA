package com.dsa.recursion.programs;

import java.util.Scanner;

public class FibonacciSeries {
	public static int count = 0;
	public static int limit = 0;
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter Number");
		limit = sc.nextInt();
		int first = 0;
		int second = 1;
		System.out.print(first + ", " +second);
		printFiboncciSeries(first, second);
	}
	private static void printFiboncciSeries(int first, int second) {
		if (count < limit - 2) {
			int sum = first + second;
			first = second;
			second = sum;
			System.out.print(","+sum);
			count++;
			printFiboncciSeries(first, second);
		}
	}
}
