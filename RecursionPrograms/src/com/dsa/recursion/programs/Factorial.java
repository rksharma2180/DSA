package com.dsa.recursion.programs;

import java.util.Scanner;

public class Factorial {
	static Scanner sc = new Scanner(System.in);
	static int result = 0;
	static int fact = 1;
	public static void main(String[] args) {
		System.out.print("Enter limit to print from");
		int n = sc.nextInt();
		result  = getFactorial(n);
		System.out.println(result);
	}

	private static int getFactorial(int n) {
		if (n == 0)
			return fact;
		else if (n > 1)
			fact =  n * getFactorial(n - 1);
		return fact;
	}
}
