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
package Question4;


/**
*
Class description 
.
*
* @version1.10 13 Jul 2017
* @author Pawan Mangalni
*/

public class FCFS {

	   protected int[][] implemetFcfs(int arival_time[], int job_size[]) {
	        int len = arival_time.length;
	        int result[][] = new int[len][5];
	        int waiting_time[] = new int[len];
	        /*
	         job num | arival_time | waiting_time | start_time | finished_time
	                 |             |              |            |              
	                 |             |              |            |              
	                 |             |              |            |              
	                 |             |              |            |              
	        */
	        waiting_time[0] = 0;
	        //job_number
	        result[0][0] = 1;
	        //arival time
	        result[0][1] = arival_time[0];
	        //waiting time
	        result[0][2] = waiting_time[0];
	        //start time
	        result[0][3] = arival_time[0];
	        //finished time
	        result[0][4] += job_size[0];

	        int index;
	        for (index = 1; index < len; index++) {
	            
	            //job number
	            result[index][0] = index+1;
	            //arrival time
	            result[index][1] = arival_time[index];
	          
	            
	            if(arival_time[index]<=result[index-1][4]) {
	                waiting_time[index] += (1 + result[index-1][4] - arival_time[index]);
	                result[index][2] = waiting_time[index];
	                //start time
	                result[index][3] = result[index-1][4]+1;
	            }
	            else if(arival_time[index] > result[index-1][4]) {
	                waiting_time[index] = 0;
	                result[index][2] = 0;
	                
	                //start time
	                result[index][3] = arival_time[index];
	            }
	               //finish_time = start_time + job_size
	                result[index][4] += (result[index][3]+job_size[index] - 1);
	        }

	        return result;
	    }
	   
	   public static void main(String[] args) {
		   FCFS obj = new FCFS();
		   int arival_time[] = {0,3,5};
		   int job_size[] = {3,2,1};
		   int result[][] = obj.implemetFcfs(arival_time, job_size);
		   System.out.println("num " + "arrival " + "wait " + "start " + "finish ");
		   for(int i=0 ; i<3 ; i++) {
			   for(int j=0 ; j<5 ; j++) {
				   System.out.print(result[i][j] + "      ");
			   }
			   System.out.println();
		   }
	   }
	}