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
package Question3;

/**
 *
 Class description .
 *
 * @version1.10 13 Jul 2017
 * @author Pawan Mangalni
 */

public class LongestIncreasingSequence {

	int[] longestSequence(int input[]) {

		// variable start and end will store the starting index and ending index
		// of array
		// variable max will store the length of sequence and compare it to the
		// older length
		// length will store the maximum length
		int start = 0, end = 0, length = 0, index, max = 0;
		int arrayLength = input.length;

		for (index = 1; index < arrayLength; index++) {
			if (input[index] > input[index - 1]) {
				max++;
			}

			else {
				if (max > length) {
					length = max;
					end = index;
					start = end - length - 1;
				}
				max = 0;
			}
		}

		// this condition will work when the last element is also the part of
		// the longest sequence
		if (max > length) {
			length = max;
			end = index;
			start = end - length - 1;
		}

		int resultLength = end - start;

		// this condition will work if all the elements in array are same
		if (resultLength == 0) {
			resultLength += 1;
		}
		int result[] = new int[resultLength];

		for (index = 0; index < resultLength; index++, start++) {
			result[index] = input[start];
		}

		return result;
	}
}
