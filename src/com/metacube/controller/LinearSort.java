/*
 * @author Pawan Manglani
 * @version 1.1 31-Aug-2017
 */
package com.metacube.controller;

import com.metacube.io.Input;

/**
 * The Class LinearSort.
 * This class applies linear sorting on arrays
 */
public class LinearSort implements Sort {

	/**
	 * This method sort the array.
	 *
	 * @param numbers the numbers
	 */
	@Override
	public void sort(int[] numbers) {
		try{
			helper(numbers);
		}catch(Exception e) {
			Input.print(e.getMessage());
		}
	}
	/**
	 * Check sort.
	 *
	 * @param numbers the numbers
	 * @return the string which tells about the sorting technique
	 */
	private String checkSort(int[] numbers) {
		int len = numbers.length;
		String result = "CountingSort";
		for(int index = 0 ; index<len ; index++) {
			if(numbers[index]>99 || numbers[index]<(-99)) {
				result = "RadixSort";
			}
		}
		return result;
	}

	/**
	 * Radix sort.
	 *
	 *This method sorts the array using radix sort
	 * @param numbers the numbers
	 */
	private void radixSort(int[] numbers) {

		/*index is use to iterate the array*/
		/*max will find the maximum number from array*/
		/*len store the length of input array*/
		int index, max = findMax(numbers), len = numbers.length;

		/*temp is a helping variable */
		/*exp is the exponent variable used to find the radix of element*/
		int temp,exp = 1;
		/*B is helping array which sorts the array element by there radix*/
		int[] b = new int[len];
		/*this loop runs till the maximum value is not zero*/
		while (max / exp > 0) {

			int[] bucket = new int[10];

			/*Taking least significant digit in bucket*/
			for (index = 0; index < len; index++) {
				bucket[(numbers[index] / exp) % 10]++;
			}
			/*Summing up the bucket values*/
			for (index = 1; index < 10; index++) {
				bucket[index] += bucket[index - 1];
			}
			/*this loop will take the radix value count store in bucket and store them in array b*/
			for (index = len - 1; index>= 0; index--) {
				temp = (--bucket[(numbers[index] / exp) % 10]); 
				b[temp] = numbers[index];
			}
			/*copying the array into original array*/
			for (index = 0; index < len; index++) {
				numbers[index] = b[index];
			}
			/*Increasing the exponent*/
			exp *= 10;
		}
	}

	/**
	 * Helper.
	 * Helper Function to sort the array 
	 * @param numbers the numbers
	 */
	private void helper(int[] numbers) throws Exception {
		if(numbers==null) {
			throw new Exception("Array is not Initialized");
		}
		/*len stores the length of array numbers*/
		int len = numbers.length;
		/*negative array store the negative numbers*/
		int negativeArray[] = new int[len];
		/*positive array store the positive numbers*/
		int positiveArray[] = new int[len];
		/*nIndex,pIndex,index are helper variable*/
		int nIndex = 0,pIndex = 0,index = 0;
		/*This loop separate the array in negative and positive array*/
		for( index = 0 ; index< len ; index++) {
			if(numbers[index]<0) {
				negativeArray[nIndex] = (numbers[index] * (-1));
				nIndex++;
			} else {
				positiveArray[pIndex] = numbers[index];
				pIndex++;
			}
		}
		/*This block will call appropriate method to sort the array*/
		String sortingTechnique = checkSort(numbers);
		if(sortingTechnique.equalsIgnoreCase("CountingSort")) {
			/*calling sort on both the arrays*/
			countingSort(negativeArray);
			countingSort(positiveArray);
		} else {
			/*calling sort on both the arrays*/
			radixSort(negativeArray);
			radixSort(positiveArray);
		}
		Input.print("System has used " + sortingTechnique + " technique and sorted list as below :");
		nIndex--;
		index = 0;
		/*store elements of negative array in main array*/
		while(nIndex >= 0) {
			numbers[index] = (negativeArray[len - 1 - index] * (-1));
			index++;
			nIndex--;
		}
		/*store elements of positive array in main array*/
		while(index<len) {
			numbers[index] = (positiveArray[index]);
			index++;
		}
	}

	/**
	 * Counting sort.
	 * This method sort the array using Counting sort
	 * @param numbers the numbers
	 */
	private void countingSort(int[] numbers) {
		/*max will find the maximum number from array*/
		int max = findMax(numbers);
		/*numArray will count the occurrence of an element in array*/
		int[] numArray = new int[max+1];
		/*Counting occurrence*/
		for (int element : numbers) {
			numArray[element]++;
		}
		/*count and pos is the helper variable*/
		int count = 0,pos = 0;
		/*This loop is storing the result in original array*/
		for (int index = 0; index < numArray.length; index++) {
			count = numArray[index];
			for (int start = 0; start < count; start++) {
				numbers[pos] = index;
				pos++;
			}
		}
	}

	/**
	 * Find max.
	 *
	 * @param numbers the numbers
	 * @return the int value max of an array
	 */
	private int findMax(int[] numbers) {
		int max = numbers[0];
		/*Finding the max value from array*/
		for (int index = 1; index < numbers.length; index++) {
			if (numbers[index] > max) {
				max = numbers[index];
			}
		}
		return max;
	}
}


