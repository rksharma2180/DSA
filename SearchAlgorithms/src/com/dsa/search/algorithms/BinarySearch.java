package com.dsa.search.algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		System.out.println("Enter a numbre to search from ");
		Arrays.stream(arr).forEach(System.out::println);
		int element = sc.nextInt();
		// int result = performBinarySearch1(arr, element);
		int result = recursiveBinarySearch(arr, 0, arr.length - 1, element);
		if (result != -1)
			System.out.println("Element found at " + result);
		else 
			System.out.println("Element does not exist. ");
	}

	private static int recursiveBinarySearch(int[] arr, int start, int end, int element) {
		int mid = start + (end - start) / 2;
		if (arr[mid] == element) {
			return mid;
		}

		if (arr[mid] > element)
			end = mid - 1;
		else
			start = mid + 1;
		if(start <= end)
			return recursiveBinarySearch(arr, start, end, element);
		else {
			return -1;
		}
	}

	private static int performBinarySearch(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;
		int mid = start + ((end - start) / 2);

		while (mid != start || mid != end) {
			if (arr[mid] == element) {
				return mid;
			}

			if (arr[mid] > element) {
				mid = start + ((mid - start) / 2);
			} else {
				mid = mid + ((end - mid) / 2);
			}
		}
		return -1;
	}

	private static int performBinarySearch1(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == element) {
				return mid;
			}

			if (arr[mid] > element) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
