//package com.greatlearning.Currency.main;

import java.util.Scanner;
import java.util.Arrays;

//import com.greatlerning.Currency.model.CurrencyDenomination;

public class Q2SolutionCurrentyDenomination {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter the size of currency denominations");
		int numberOfDenominations = s.nextInt();

		int[] arrDenominations = new int[numberOfDenominations];
		System.out.println("Enter the currency denominations value");
		for (int i = 0; i < numberOfDenominations; i++) {
			arrDenominations[i] = s.nextInt();
		}
		
		CurrencyDenomination objCD = new CurrencyDenomination();
		//CurrencyDenomination.mergeSort(arrDenominations);
		objCD.mergeSort(arrDenominations);
		int[] counter = new int[numberOfDenominations];

		System.out.println("Enter the amount you want to pay");
		int amountToPay = s.nextInt();

		int remainingAmount = countNotes(arrDenominations, counter, 0, numberOfDenominations - 1, amountToPay);

		if (remainingAmount > 0) {
			System.out.println("Amount cannot be paid in give denominations!");
		} else {
			System.out.println("Your payment approach in order to give min no of notes will be");
			// for(int i = numberOfDenominations-1; i>=0; i--)
			for (int i = 0; i <= numberOfDenominations - 1; i++) {
				if (counter[i] != 0) {
					// System.out.println("Denomination of " + arrDenominations[i] + ":" +
					// counter[i]);
					System.out.println(
							arrDenominations[i] + " x " + counter[i] + " = " + arrDenominations[i] * counter[i]);
				}
			}
			s.close();
		}
	}

	public static int countNotes(int[] arrDenominations, int[] counter, int low, int high, int amountToPay) {
		if (amountToPay == 0) {
			return 0;
		}
		if (amountToPay < arrDenominations[0]) {
			return amountToPay;
		}

		if (amountToPay >= arrDenominations[high]) {
			counter[high] = amountToPay / arrDenominations[high];
			amountToPay %= arrDenominations[high];
			// return countNotes(arrDenominations, counter, 0, high-1, amountToPay);
			// high-1 in line 72 instead of high in line 73 throwing exception to d1=6,
			// d1d2=16, d1d2=26,...d1d2d36
			// Try this code by uncommenting line 72 and commenting line 73
			// Discuss why it is happening
			return countNotes(arrDenominations, counter, 0, high, amountToPay);
		}
		int mid = (low + high) / 2;
		if (amountToPay < arrDenominations[mid]) {
			return countNotes(arrDenominations, counter, 0, mid - 1, amountToPay);
		}
		return countNotes(arrDenominations, counter, 0, high - 1, amountToPay);
	}

}

class CurrencyDenomination {
		
	public static void mergeSort(int[] array) {
			splitAndMerge(array, 0, array.length - 1);
		}
		private static void splitAndMerge(int[] array, int left, int right) {
			if (left < right) {
				int mid = (left + right) / 2;
				splitAndMerge(array, left, mid);
				splitAndMerge(array, mid+1, right);
				merge(array, left, mid, right);
			}
		}
		private static void merge(int[] array, int left, int mid , int right) {
			int n1 = mid - left + 1;	// size of the left array
			int n2 = right - mid;		// size of the right array
			int[] leftArray = new int[n1];
			int[] rightArray = new int[n2];
			for (int i = 0; i < n1; i++) {
				leftArray[i] = array[left + i];
			}
			for (int i = 0; i < n2; i++) {
				rightArray[i] = array[mid + 1 + i];
			}
			int i = 0, j = 0;
			int k = left;
			while (i < n1 && j < n2) {
				if (leftArray[i] < rightArray[j]) {
					array[k++] = leftArray[i++];
				} else {
					array[k++] = rightArray[j++];
				}
			}
			while (i < n1) {
				array[k++] = leftArray[i++];
			}
			while (j < n2) {
				array[k++] = rightArray[j++];
			}
	}

	}