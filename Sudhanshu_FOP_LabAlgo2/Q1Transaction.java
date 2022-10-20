//package com.greatlearning.iitr.dsa.labsession2;
import java.util.Scanner;


class Q1Transaction {
	public static void main(String args[]) throws Exception {
		
		Scanner s = new Scanner(System.in);
		System.out.println("enter the size of transaction array");
		int size = s.nextInt();
		int arr[] = new int[size];
		int arrSum = 0;
		int arrTempSum = 0;
		
		System.out.println("enter the values of array");

		for (int i=0; i<size; i++){
			arr[i] = s.nextInt();
			arrSum += arr[i];
		}

		System.out.println("Total value of Transactions : " + arrSum);

		System.out.println("/nEnter the total no of targets that needs to be achieved");
		int targetNo = s.nextInt();
		System.out.println("/nTotal No. of Target : " + targetNo);

		System.out.println("/nEnter the value of target");
		int targetVal = s.nextInt();
		System.out.println("/nTarget Value : " + targetVal);

		if(targetVal > arrSum)
		{
			System.out.println("/nGiven target is not achieved : " + targetVal + " > " + arrSum);
		}


		for (int i=0; i<=size-1; i++){
			arrTempSum += arr[i];

			if(arrTempSum >= targetVal) {
					System.out.println("/nTarget achieved after " + (i+1) + " transaction(s)");
					break;
			}
		}
	}
}
