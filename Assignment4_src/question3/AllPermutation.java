package question3;

import java.util.*;

/**
 * Class description
 * 
 *  The Class AllPermutation used to generate all permutation.
 * 
 * @version1.10 19 Jul 2017
 * @author Pawan Manglani
 */
public class AllPermutation {

	/** The result. contains the different different permutation in sorted order */
	private TreeSet<String> result = new TreeSet<>();

	/**
	 * The main method.
	 *
	 * @param args the command line arguments
	 *            
	 */
	public static void main(String[] args) {

		AllPermutation obj = new AllPermutation();
		String input = "";
		List<String> answer = obj.generatePermute(input);
		Iterator<String> itr = answer.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next());
		}
	}

	/**
	 * Generate permute Method. This method is public and used as a controller
	 * function to generate all the possible combination of a string
	 *
	 * @param input the input string
	 * @return the list contain the result
	 */
	public List<String> generatePermute(String input) {
		List<String> resultList = new ArrayList<>();
		try {
			if (input.length() == 0) {
				throw new IllegalArgumentException();
			}
			String[] ourArray = input.split("");
			permute(ourArray, ourArray.length);
			Iterator<String> itr = result.iterator();
			while (itr.hasNext()) {
				resultList.add(itr.next());
			}
		} catch (NullPointerException e) {
			resultList.add("Null Pointer Exception Occur");
		} catch (IllegalArgumentException e) {
			resultList.add("Invalid Argument Empty String");
		}
		return resultList;
	}

	/**
	 * Swap Method. This methd is used to swap elements store at right and left
	 * position of array
	 *
	 * @param ourarray the array of input string elements
	 *           
	 * @param right the right position of array
	 *            
	 * @param left the left position of array
	 *            
	 */
	private void swap(String[] ourarray, int right, int left) {
		String temp = ourarray[right];
		ourarray[right] = ourarray[left];
		ourarray[left] = temp;
	}

	/**
	 * Permute Method. This method recursively call itself and generate
	 * permutation
	 * 
	 * This generates all of the permutations that end with the last element.
	 * Then if n is odd, we switch the first element and the last one, while if
	 * n is even we can switch the ith element and the last one (there is no
	 * difference between n even and odd in the first iteration). We add one to
	 * the counter i and repeat. In each iteration, the algorithm will produce
	 * all of the permutations that end with the element that has just been
	 * moved to the "last" position.
	 * 
	 * 
	 * 
	 * @param ourarray the array of input string elements
	 *            
	 * @param currentPosition the current position
	 *            
	 */
	private void permute(String[] ourArray, int currentPosition) {
		if (currentPosition == 1) {
			result.add(Arrays.toString(ourArray));
		} else {
			for (int i = 0; i < currentPosition; i++) {
				// subtract one from the last position (here is where you are
				// selecting the the next last item
				permute(ourArray, currentPosition - 1);

				// if it's odd position
				if (currentPosition % 2 == 1) {
					swap(ourArray, 0, currentPosition - 1);
				} else {
					swap(ourArray, i, currentPosition - 1);
				}
			}
		}
	}
}