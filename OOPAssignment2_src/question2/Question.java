package question2;

import java.util.HashMap;

/**
 * The Class Question.
 * 
 * @author Pawan Manglani
 * @version1.10 21 Jul 2017
 */
public class Question implements Comparable<Question> {

    /** The question string. */
    private String questionString;
    
    /** The type of question. */
    private String typeOfQuestion;
    
    /** The options. */
    private String options;
    
    /** The option map. */
    private HashMap<String,Integer> optionMap = new HashMap<>();

	public HashMap<String, Integer> getOptionMap() {
		return optionMap;
	}

	public void setOptionMap(HashMap<String, Integer> optionMap) {
		this.optionMap = optionMap;
	}

	/**
	 * Gets the type of question.
	 *
	 * @return the type of question
	 */
	public String gettypeOfQuestion() {
		return this.typeOfQuestion;
	}

	/**
	 * Sets the type of question.
	 *
	 * @param typeOfQuestion the new type of question
	 */
	public void settypeOfQuestion(String typeOfQuestion) {
		this.typeOfQuestion = typeOfQuestion;
	}

	/**
	 * Gets the options.
	 *
	 * @return the options
	 */
	public String getOptions() {
		return this.options;
	}

	/**
	 * Sets the options.
	 *
	 * @param options the new options
	 */
	public void setOptions(String options) {
		this.options = options;
	}

	/**
	 * Sets the question string.
	 *
	 * @param questionString the new question string
	 */
	public void setquestionString(String questionString) {
		this.questionString = questionString;
	}

	/**
	 * Gets the question string.
	 *
	 * @return the question string
	 */
	public String getquestionString() {
        return this.questionString;
    }
      
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Question t) throws NullPointerException {

        String aStr = questionString, bStr = t.questionString;
        return aStr.compareTo(bStr);
    }
}
