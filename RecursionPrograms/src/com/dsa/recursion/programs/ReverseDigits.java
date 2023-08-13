package com.dsa.recursion.programs;

import java.util.Scanner;

public class ReverseDigits {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		reverse(n);
	}

	public static void reverse(int n) {
		if(n <10) {
			System.out.println(n);
			return;
		}
		
		if (n > 0) {
			System.out.print(n % 10);
			reverse(n / 10);
		}
	}
}
