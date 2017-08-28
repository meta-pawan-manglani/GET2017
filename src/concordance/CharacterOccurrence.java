package concordance;

import io.Input;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * The Class CharacterOccurrence.
 * This class gives the position of each character of a string
 *  @author Pawan Manglani
 *  @version 1.1 27-Aug-2017
 */
public class CharacterOccurrence {

	/**
	 * This method gives the occurrence of each character of string
	 * @param args
	 * @throws NullPointerException
	 */
	public static String getOccurence(String[] args) throws NullPointerException{
		/**
		 * len store the length of arguments
		 */
		int len = args.length;
		/**
		 * Map to store the character frequencies
		 */
		TreeMap<Character,List<Integer>> occurrenceMap = new TreeMap<>();
		/**
		 * Helper variables
		 */
		String str = "";
		List<Integer> list;
		int position = 0 ; //position will store the count on which position the element occur 
		char c;

		/**
		 * This loop will count the frequencies
		 */
		for(int index = 0 ; index<len ; index++) {
			/**
			 * Take string from arguments
			 */
			str = args[index].trim();
			/**Traverse this string**/
			for(int stringIndex = 0 ; stringIndex<str.length() ; stringIndex++) {
				/**
				 * Increment the position as we want string should be 1-index based
				 */
				position++;
				/**
				 * take first character
				 */
				c = str.charAt(stringIndex);
				/**
				 * Check if map already contains the character than get the list of that character
				 * else initialize new list
				 */
				if(occurrenceMap.containsKey(c)) {
					list = occurrenceMap.get(c);

				} else {
					list = new ArrayList<>();
				}
				/**
				 * Put position in that list
				 */
				list.add(position);
				/**
				 * put this list in map
				 */
				occurrenceMap.put(c,list);
			}
		}
		/**
		 * Make a set of keys of map
		 */
		Set<Character> keys = occurrenceMap.keySet();
		/**
		 * Make a iterator of the keys
		 */
		Iterator<Character> itr = keys.iterator();
		/**
		 * Now string str is used to store the result
		 */
		str = "";
		while(itr.hasNext()) {
			/**
			 * iterate over the key
			 */
			c = itr.next();
			/**
			 * get list of that character
			 */
			list = occurrenceMap.get(c);
			/**
			 * append the list to result
			 */
			str += c + list.toString() + " ";
		}
		occurrenceMap.clear();
		return str;
	}


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			/**
			 * If length of argument is 0
			 */
			if(args.length==0) {
				Input.print("Empty Arguments");
			} else {
				/**
				 * Calling the get occurrence method
				 */
				Input.print(getOccurence(args));
			}
		}catch(Exception e) {
			Input.print("Error Occured " + e.getMessage());
		}

	}
}
