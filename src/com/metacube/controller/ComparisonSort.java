/*
 * @author Pawan Manglani
 * @version 1.1 31-Aug-2017
 */
package com.metacube.controller;

import com.metacube.io.Input;

/**
 * The Class ComparisonSort.
 * This class applies Comparison Based Sort on Arrays
 */
public class ComparisonSort implements Sort{


	/**
	 * Sort
	 * 
	 * This method sort the array
	 */
	@Override
	public void sort(int[] numbers) {
		String sortingTechnique = "System has used ";
		try {
			if(numbers==null) {
				throw new NullPointerException("Array is Not Initialized");
			}
			int len = numbers.length;
			/*If length is less than 10 call bubble sort else quick sort*/
			if( len < 10) {
				sortingTechnique += "Bubble sort technique and sorted list as below :";
				bubbleSort(numbers);
			} else {
				sortingTechnique += "Quick sort technique and sorted list as below :";
				quickSort(numbers,0,len-1);
			}
			Input.print(sortingTechnique);
		}catch(Exception e) {
			Input.print(e.getMessage());
		}
	}

	/**
	 * Bubble sort.
	 * This method applies bubble sort on input array
	 * @param arr the array of elements
	 */
	private void bubbleSort(int[] arr) { 
		/*len will store the length of array*/
		int len = arr.length;  
		/*temp is helper variable*/
		int temp = 0;  
		/*This loop performs sorting on array*/
		for(int i=0; i < len; i++) {  
			for(int j=1; j < (len-i); j++) {  
				if(arr[j-1] > arr[j]){  
					/*swap elements*/  
					temp = arr[j-1];  
					arr[j-1] = arr[j];  
					arr[j] = temp;  
				}  

			}  
		}
	}

	/**
	 * Quick sort.
	 *
	 * This method applies Quick Sort on Array
	 * @param a the a
	 * @param l the l
	 * @param h the h
	 */
	private void quickSort(int a[],int l,int h) {
		/*Helper Variable*/
		int temp,key,low,high;
		low = l;
		high = h;
		/*key is the pivot element*/
		key = a[(low + high)/2];
		do {
			/*if key value is greater than lower value increment the lower index*/
			while(key > a[low]) {
				low++;
			}

			/*if key value is lesser than higher value decrement the high index*/
			while(key < a[high]) {
				high--;
			}

			/*This condition swap the element*/
			if(low<=high) {
				temp = a[low];
				a[low++] = a[high];
				a[high--] = temp;
			}
		}while(low<=high);

		/*Calling to quick sort for lower half*/
		if(l < high) {
			quickSort(a,l,high);
		}
		/*calling to quick sort for upper half*/
		if(low < h) {
			quickSort(a,low,h);
		}
	}
}
