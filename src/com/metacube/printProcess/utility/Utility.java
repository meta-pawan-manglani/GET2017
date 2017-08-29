package com.metacube.printProcess.utility;

import com.metacube.printProcess.entity.Task;
import com.metacube.queue.CustomQueue;

/**
 * The Class Utility.
 * 
 * @author Pawan Manglani
 * @version 1.1 25-Aug-2017
 */
public class Utility {

	private static int N;

	/* Sort Function */

	public static void sort(CustomQueue<Task> jobs) {
		Object arr[] = jobs.toArray();
		try{
		N = arr.length-1;
		heapify(arr);
		/*Again putting the data into the queue*/
		jobs.makeEmpty();
		N = arr.length;
		for(int index =0 ; index <N ; index++){
			jobs.enqueue(arr[index]);
		 }
		}catch(Exception e){
			System.out.println("Error caught " + e.getMessage());
		}
	}

	/* Function to build a heap */

	private static void heapify(Object arr[]) {
		N = arr.length - 1;
		for (int index = N / 2; index >= 0; index--){
			maxheap(arr, index);
		}
	}

	/* Function to swap largest element index heap */

	@SuppressWarnings("unchecked")
	private static void maxheap(Object arr[], int index) {
		int left = 2 * index;
		int right = 2 * index + 1;
		int max = index;
		/*Check if left child is greater than index*/
		if (left <= N && ((Comparable<Task>)arr[left]).compareTo((Task) arr[index]) > 0) {
			max = left;
		}
		/*Check if right child is greater than index*/
		if (right <= N && ((Comparable<Task>)arr[right]).compareTo((Task) arr[max]) > 0 ) {
			max = right;
		}
		/*If max is changed than swap the values*/
		if (max != index)
		{
			swap(arr, index, max);
			maxheap(arr, max);
		}
	}

	/* Function to swap two numbers index an array */
	private static void swap(Object arr[], int index, int j) {
		Object tmp = arr[index];
		arr[index] = arr[j];
		arr[j] = tmp;

	}

}
