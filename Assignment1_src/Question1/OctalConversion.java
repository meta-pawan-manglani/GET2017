
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
package Question1;


/**
*
Class description 
.
*
* @version1.10 13 Jul 2017
* @author Pawan Mangalni
*/

public class OctalConversion {
	
	//program for decimal conversion

	public int convertBinaryToOctal(int n) {
		
		//checkBinary will check if input number is binary or not
		int checkBinary = n, remainder;
		while (checkBinary!=0) {
			remainder = checkBinary % 10;
			if ((remainder == 0) || (remainder == 1)) {
				checkBinary = checkBinary / 10;
			} else {
				break;
			}
		}
		
		//decimalnum will store the decimal value of binary number
		int decimalnum = 0, j = 1;

		while (n > 0) {
			remainder = n % 10;
			decimalnum = decimalnum + (remainder * j);
			j = j * 2;
			n = n / 10;
		}
        
		//octal[] is the array which will store the grouped 
		int octal[] = new int[100];
		int i = 0, octalnum = 0;
		
		//octalnum wil store the result
		
		while (decimalnum != 0) {
			octal[i] = decimalnum % 8;
			decimalnum = decimalnum / 8;
			i++;
		}
		String result = "";
		for (j = i - 1; j >= 0; j--) {
			result = result + Integer.toString(octal[j]);
		}
		octalnum = Integer.parseInt(result);
		if (checkBinary != 0) {
			octalnum = -1;
		}
		return octalnum;
	}

}
