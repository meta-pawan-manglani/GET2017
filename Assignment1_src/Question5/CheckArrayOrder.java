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
package Question5;

/**
 *
 Class description .
 *
 * @version1.10 13 Jul 2017
 * @author Pawan Mangalni
 */

public class CheckArrayOrder {

	// check if array is sorted in ascending order
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

	// check sorted order of array
	int isSorted(int[] input) {

		boolean ascending = false, decending = false;
		ascending = isAscending(input);
		int order;

		// if array is not in ascending order check for descending order
		if (!ascending) {
			decending = isDescending(input);

			// if array is not in descending order then it is not sorted
			if (!decending) {
				order = 0;
			} else {
				// array is sorted in descending order
				order = 2;
			}
		} else {
			// array is sorted in ascending order
			order = 1;
		}

		return order;
	}
}
