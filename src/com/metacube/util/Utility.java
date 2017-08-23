/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.util;



import com.metacube.counselling.entity.Student;
import com.metacube.queue.CustomQueue;

/**
 *
 * @author Pawan Manglani
 * @version 1.1 21-Aug-2017
 */
public class Utility {


	/**This method sort the queue 
	 *     
	 * @param queue
	 */
	public static <T extends Object> void sort(CustomQueue<T> queue) {
		Object[] a = queue.toArray();
		queue.makeEmpty();
		mergeSort(a,0,a.length-1);
		for(int i=0 ; i<a.length ; i++){
			queue.enqueue(a[i]);
		}
	}
	/**
	 * Merge Sort Method
	 * @param arValues
	 * @param low
	 * @param high
	 */
	private static void mergeSort(Object[] arValues, int low, int high) {
		if (low < high) {
			// Get the middle of the array.
			int middle = low + ((high - low) / 2);
			// Divide.
			mergeSort(arValues, low, middle);
			mergeSort(arValues, middle + 1, high);
			// Conquer.
			merge(arValues, low, middle, high);
		}
	}
	/**
	 * This function merge the two halves
	 * @param arValues
	 * @param low
	 * @param middle
	 * @param high
	 */
	private static  void merge(Object[] arValues, int low, int middle, int high) {
		// The amount of numbers to sort.
		int numbersToSort = (high - low) + 1;
		// Temp array to contain the sorted elements of this iteration.
		Object arTemp[] = new Object[numbersToSort];
		int i = low;
		int j = middle + 1;
		Object lowValue = null;
		Object highValue = null;
		for (int k = 0; k < numbersToSort; k++) {
			lowValue = (i <= middle) ? arValues[i] : null;
			highValue = (j <= high) ? arValues[j] : null;
			if (checkBiggerSmaller(lowValue, highValue)) {
				arTemp[k] = arValues[i++];
			} else {
				arTemp[k] = arValues[j++];
			}
		}
		// Transfer the sorted elements to the original array.
		for (int k = 0; k < numbersToSort; k++) {
			arValues[low + k] = arTemp[k];
		}
	}

	/**
	 * This function finds the smaller value   
	 * @param lowValue
	 * @param highValue
	 * @return true if low value is smaller than high value
	 */
	private static boolean checkBiggerSmaller(Object lowValue, Object highValue) {
		boolean isGreater = false;
		boolean flag = true;
		if ((lowValue != null) && (highValue == null)) {
			isGreater = true;
			flag = false;
		} else if ((lowValue == null) && (highValue != null)) {
			isGreater = false;
			flag = false;
		}
		if (flag) {
			isGreater = ((Student)lowValue).compareTo(highValue) <= 0;
		}
		return isGreater;
	}

}
