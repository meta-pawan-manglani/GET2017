package queue;

import io.Input;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The Class CustomQueue.
 * This is the custom queue class
 * @author Pawan Manglani
 * @version 1.1 27-Aug-2017
 * @param <T> the generic type
 */
public class CustomQueue<T> {

	/** The queue. */
	private Queue<T> queue;

	/**
	 * Instantiates a new custom queue.
	 */
	public CustomQueue() {
		queue = new LinkedList<T>();
	}

	/**
	 * Enqueue. Adding an item in queue
	 *
	 * @param data the data
	 */
	public void enqueue(T data) {
		try {
			queue.add(data);
		}catch(Exception e) {
			Input.print("Error Occured while adding " + e.getMessage() + "\n");
		}
	}

	/**
	 * Dequeue. Delete an item from queue
	 *
	 * @return the t
	 * @throws Exception 
	 */
	public T dequeue() throws Exception {
		if(queue.isEmpty()) {
			throw new Exception("Queue is Empty");
		}
		return queue.remove();
	}

	/**
	 * Prints the.Queue
	 *
	 * @return the string
	 */
	public String print() {
		String printer = "";
		try {
			if(queue.isEmpty()) {
				printer = "Queue is Empty";
			} else {
				printer = queue.toString();
			}
		}catch(Exception e) {
			Input.print("Error Occured in printing " + e.getMessage() + "\n");
		}
		return printer;
	}

	/**
	 * Clear queue.
	 * This method clear the queue
	 */
	public void clearQueue() {
		try {
		queue.clear();
		}catch(Exception e) {
			Input.print("Error Occured while clearing the queue " + e.getMessage());
		}
	}
}
