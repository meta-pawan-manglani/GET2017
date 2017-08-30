package com.metacube.controller;

import java.util.Arrays;

import com.metacube.io.Input;

/**
 * @author Pawan Manglani
 * @version 1.1 30-Aug-2017
 */
public class ArrayController {


	/* Returns index of x if it is present in numbers[l..r], else return -1 */
	public static int binarySearch(int[] numbers,int left, int right, int key)
	{
		if (right>=left)
		{
			int mid = left + (right - left)/2;

			/* If the element is present at the middle itself*/
			if (( mid == 0 || key > numbers[mid-1]) && numbers[mid] == key) {
				return mid;
			}
			/* If element is smaller than mid, then it can only
			 be present in left sub part of numbers */
			if (key >numbers[mid]) {
				return binarySearch(numbers,mid+1, right, key);
			} 
			/* Else the element can only be present in right
			 part of numbers */
			return binarySearch(numbers,left, mid-1, key);
		}

		/* We reach here when element is not present in numbers */
		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			/*Take input from user*/
			int size = Input.takeIntegerAsInput("Number of Element you want to add");
			/*initialize number array*/
			int[] numbers = new int[size];
			/*taking inputs from user*/
			for(int index = 0 ; index<numbers.length ; index++) {
				numbers[index] = Input.takeIntegerAsInput("Element");
			}
			/*Sorting the array*/
			Arrays.sort(numbers);
			/*Taking element which has to search*/
			int key = Input.takeIntegerAsInput("Element to searched");
			/*Print the position*/

			Input.print(Integer.toString(binarySearch(numbers,0,size-1,key)));
		}catch(Exception e) {
			Input.print("Error caught " + e.getMessage());
		}
	}

}
