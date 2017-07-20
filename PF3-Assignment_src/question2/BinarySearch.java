package question2;

/**
 * Class description
 * 
 * This class will search an entry in an array using binary search technique
 * 
 * @version1.10 18 Jul 2017
 * @author Pawan Manglani
 */
public class BinarySearch {


	private int[] numbers;
	private int[] helper;

	private int number;

	public void sort(int[] values) {
		this.numbers = values;
		number = values.length;
		this.helper = new int[number];
		mergesort(0, number - 1);
	}

	private void mergesort(int low, int high) {
		// check if low is smaller than high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				i++;
			} else {
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			k++;
			i++;
		}

	}
	/**
	 * @param arr is the array on which the search is applied
	 * @param start denotes the lower bound of the array
	 * @param last denotes the higher bound of the array
	 * @param num is the number for which we are looking
	 */
	protected int binarySearch(int[] arr, int start, int last, int num)
			throws Exception {
		if (arr.length <= 0) {
			throw new IllegalArgumentException();
		}
		int mid = (start + last) / 2;
		if (start > last) {
			// terminating condition and will run when the search goes out of
			// the boundary
			return -1;
		}
		if (arr[mid] == num) {
			// if number is equal to mid value of array return the index
			return mid;
		}

		if (num > arr[mid]) {
			// if number is greater than mid value of array search in right half
			// of the array
			return binarySearch(arr, mid + 1, last, num);
		}

		// if number is less than mid value of array search in left half of the
		// array
		return binarySearch(arr, start, mid - 1, num);
	}

	public static void main(String[] args) {
		// application logic here
		BinarySearch obj = new BinarySearch();
		try {
			int target = 89;
			int arr[] = { 75, 1, 101, 67, 89 };
			obj.sort(arr);
			arr = obj.numbers;
			//sorted array will be {1,67,75,89,101}
			int end = arr.length - 1;
			System.out.println(obj.binarySearch(arr, 0, end, target));
		} catch (Exception e) {
			System.out.println("Exception occurs");
		}
	}
}
