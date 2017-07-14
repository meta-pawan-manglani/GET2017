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

package Question2;

/**
 *
 Class description .
 *
 * @version1.10 13 Jul 2017
 * @author Pawan Mangalni
 */

public class RemoveDuplicate {
	int[] removeDuplicate(int input[]) {

		// diff will store the count of different elements
		// index is used to traverse the input array and pos is used to traverse
		// the result array
		int diff = 0, length = input.length, index = 0, pos = 0;

		// this boolean array will check if the element is already occur
		boolean count[] = new boolean[10000 + 1];
		for (index = 0; index < length; index++) {
			if (!count[input[index]]) {
				count[input[index]] = true;
				diff++;
			}
		}

		int result[] = new int[diff];
		for (index = 0; index < length; index++) {
			if (count[input[index]]) {
				result[pos] = input[index];
				// updating count value so that value will not occur again
				count[input[index]] = false;
				pos++;
			}
		}
		return result;
	}

}
