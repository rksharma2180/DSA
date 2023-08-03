package com.dsa.array.operations;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class ArrayOperation {

	static Object[] arr;
	static Scanner scanner = new Scanner(System.in);
	static int index = 0;

	public static void main(String[] args) {
		while(true)
			showOptions();
	}

	public static void showOptions() {
		int input = 0;
		System.out.println("\n Selection Options \n" + "1: Create Array \n" + "2: Add Element \n"
				+ "3: Delete Element at specified position \n" + "4: Delete Element \n" + "5: Search Element \n"
				+ "6: Show Elements \n7: Exit");
		if(scanner.hasNextInt()) {
			input = scanner.nextInt();
		}
		switch (input) {
		case 1:
			createArray();
			break;
		case 2:
			addElements();
			break;
		case 3:
			deleteElementAtPosition();
			break;
		case 4:
			deleteElement();
			break;
		case 5:
			searchElement();
			break;
		case 6:
			showElements();
			break;
		default:
			System.exit(0);
		}
	}

	private static void showElements() {
		/*
		 * Stream.of(arr).forEach(element -> {
		 * Optional.ofNullable(element).ifPresentOrElse(c ->
		 * System.out.println("Element: " + c), () -> System.out.print("")); });
		 */

		Arrays.stream(arr).forEach(element -> {
			Optional.ofNullable(element).ifPresentOrElse(c -> System.out.print(" " + c +", "), () -> System.out.print(""));
		});

	}

	private static void searchElement() {
		System.out.print("Please enter element");
		String element = scanner.next();
		if (element != null) {
			int elementIndex = performSearch(element);
			if(elementIndex != 1) {
				System.out.println("Element "+ element +" found at "+elementIndex);
			}
		}
	}

	private static void deleteElement() {
		System.out.print("Please enter element to delete");
		String element = scanner.next();
		if (element != null) {
			int elementIndex = performSearch(element);
			if(elementIndex != -1) {
				performDelete(elementIndex);
			}
		}
	}

	private static int performSearch(Object searchElement) {
		if(searchElement != null) {
			for (int beginIndex = 0; beginIndex < arr.length; beginIndex++) {
				if (arr[beginIndex].hashCode() == searchElement.hashCode()) {
					return beginIndex;
				}
			}
		}
		return -1;
	}

	public static void deleteElementAtPosition() {
		int deleteIndex = 0;
		System.out.print("Please enter index to delete element between 0 to " + index);
		if (scanner.hasNextInt()) {
			deleteIndex = scanner.nextInt();
		} else 
			return;
		performDelete(deleteIndex);
	}

	private static void performDelete(int deleteIndex) {
		try {
			if (null != arr[deleteIndex]) {
				reArrange(deleteIndex);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	private static void addElements() {
		System.out.print("Please enter element");
		String element = scanner.next();
		if (element != null) {
			arr[index++] = element;
			System.out.print("Do you want to add more elements ? Please enter Y or N");
			String addMore = scanner.next();
			if (addMore != null && addMore.equalsIgnoreCase("Y")) {
				addElements();
			}
		} else {
			System.out.print("No element provided.");
		}
	}

	private static void createArray() {
		int size = 0;
		System.out.print("Please enter array size: ");
		if(scanner.hasNextInt()) {
			size = scanner.nextInt();
		}
		if (null == arr) {
			arr = new Object[size];
			System.out.println("Array has been created successfully with size:" + size +"\n");
		}
	}

	private static void reArrange(int index) {
		int endIndex= arr.length - 1;
		for (; index+1 <= endIndex;) {
			arr[index] = arr[index+1];
			index++;
		}
		arr[endIndex] = null;
	}
}
