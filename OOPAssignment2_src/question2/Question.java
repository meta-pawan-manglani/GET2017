package question2;

/**
 * The Class Question.
 * 
 * @author Pawan Manglani
 * @version1.10 21 Jul 2017
 */
public class Question implements Comparable<Question> {

    /** The question string. */
    private String question_string;
    
    /** The type of question. */
    private String type_of_question;
    
    /** The options. */
    private String options;
    

	/**
	 * Gets the type of question.
	 *
	 * @return the type of question
	 */
	public String getType_of_question() {
		return this.type_of_question;
	}

	/**
	 * Sets the type of question.
	 *
	 * @param type_of_question the new type of question
	 */
	public void setType_of_question(String type_of_question) {
		this.type_of_question = type_of_question;
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
	 * @param question_string the new question string
	 */
	public void setQuestion_string(String question_string) {
		this.question_string = question_string;
	}

	/**
	 * Gets the question string.
	 *
	 * @return the question string
	 */
	public String getQuestion_string() {
        return this.question_string;
    }
      
    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Question t) throws NullPointerException {

        String aStr = question_string, bStr = t.question_string;
        return aStr.compareTo(bStr);
    }
}
