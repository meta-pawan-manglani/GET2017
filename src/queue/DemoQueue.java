package queue;

import io.Input;
/**
 * The Class DemoQueue.
 *  This class demos the queue operation like enqueue,dequeue,print
 *  @author Pawan Manglani
 *  @version 1.1 27-Aug-2017
 */
public class DemoQueue {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		/**
		 * Instantiate queue
		 * 
		 */
		CustomQueue<String> queue = new CustomQueue<String>();
		int choice = 0;
		String data;

		while(true) {
			try {
				/**
				 * Printing menu
				 */
				Input.printMenuForQueue();
				/**
				 * Taking user choice
				 */
				choice = Input.takeIntegerAsInput();
				switch(choice) {
				/**
				 * Case To add a data in queue
				 */
				case 1:
					data = Input.takeStringAsInput();
					queue.enqueue(data);
					break;
					/**
					 * Case to Print the queue
					 */
				case 2:
					Input.print(queue.print());
					break;
					/**
					 * Case to delete an item from queue
					 */
				case 3:
					data = queue.dequeue();
					Input.print(data);
					break;
					/**
					 * Case to Make a queue empty
					 */
				case 4:
					queue.clearQueue();
					break;
					/**
					 * In case to exit from system
					 */
				case 5:
					Input.close();
					System.exit(0);
				default :
					Input.print("Please Enter a Valid Option");
				}
			}catch(Exception e) {
				Input.print(e.getMessage());
			}
		}
	}
}
