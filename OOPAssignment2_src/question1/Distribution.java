package question1;

import question2.Question;


/**
 * The Interface Distribution.
 * 
 * @author Pawan Manglani
 * @version1.10 21 Jul 2017
 */
public interface Distribution {

	/**
	 * Count single select.
	 *
	 * This function will count the value of single select options
	 * @param key which have to be count 
	 */

	public void countSingleSelect(String key,Question q);

	/**
	 * Count total.
	 *
	 * This function will calculate percentage and make a distribution graph according to that
	 * @param totalParticipant the number of total participant
	 */

	public void countTotal(int totalParticipant);
}
