/*
 * Pawan Manglani
 *
 * Copyright (c) 2007-2017 Metacube Software Pvt. Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Metacube 
 * Software Pvt. Ltd. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Metacube.
 *
 * Metacube MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF
 * THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED
 * TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE, OR NON-INFRINGEMENT. Metacube SHALL NOT BE LIABLE FOR
 * ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR
 * DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

package Question6;

/**
 *
 Class description .
 *
 * @version1.10 13 Jul 2017
 * @author Pawan Mangalni
 */

public class MergeArray {

	// Merge input1[0..n1-1] and input2[0..n2-1] into input3[0..n1+n2-1]

	public int[] merge(int[] input1, int[] input2) {

		int len = input1.length + input2.length;
		int result[] = new int[len];
         boolean flag1 = false,flag2 = false;
         flag1 = isAscending(input1);
         flag2 = isAscending(input2);
         
         if( (flag1) && (flag2)) {
        	 result = mergeAscending(input1,input2);
         }
         
         else {
        	 result = mergeDescending(input1,input2);
         }
         return result;
	}
	
	
	boolean isAscending(int[] input) {
		int index = 0, len = input.length;
		boolean ascending = false;
		for (index = 1; index < len; index++) {
			if (input[index] < input[index - 1]) {
				ascending = false;
				break;
			}
			ascending = true;
		}

		return ascending;
	}

	// check if array is sorted in descending order
	boolean isDescending(int[] input) {
		int index = 0, len = input.length;
		boolean descending = false;
		for (index = 1; index < len; index++) {
			if (input[index] > input[index - 1]) {
				descending = false;
				break;
			}
			descending = true;
		}

		return descending;
	}
	
	
	int[] mergeAscending(int[] input1,int[] input2) {
		int len = input1.length + input2.length;
		int result[] = new int[len];
		
		int len1 = input1.length, len2 = input2.length, pos = 0;
		int index1 = 0, index2 = 0;

		while (index1 < len1 && index2 < len2) {
			if (input1[index1] < input2[index2]) {
				result[pos] = input1[index1];
				index1++;
			} else {
				result[pos] = input2[index2];
				index2++;
			}
			pos++;
		}

		// Store remaining elements of first array
		while (index1 < len1) {
			result[pos] = input1[index1];
			index1++;
			pos++;
		}

		// Store remaining elements of second array
		while (index2 < len2) {
			result[pos] = input2[index2];
			index2++;
			pos++;

		}
		return result;
	}

	
	int[] mergeDescending(int[] input1,int[] input2) {
		int len = input1.length + input2.length;
		int result[] = new int[len];
		
		int len1 = input1.length, len2 = input2.length, pos = 0;
		int index1 = 0, index2 = 0;

		while (index1 < len1 && index2 < len2) {
			if (input1[index1] > input2[index2]) {
				result[pos] = input1[index1];
				index1++;
			} else {
				result[pos] = input2[index2];
				index2++;
			}
			pos++;
		}

		// Store remaining elements of first array
		while (index1 < len1) {
			result[pos] = input1[index1];
			index1++;
			pos++;
		}

		// Store remaining elements of second array
		while (index2 < len2) {
			result[pos] = input2[index2];
			index2++;
			pos++;

		}
		return result;
	}
	
}
