/**
 * 
 */
package com.metacube.entity;


/**
 * The Class Titles.
 * pojo containing details of title table
 * @author Pawan Manglani
 * @version 1.1 12-Sep-2017
 */
public class Titles {

	/** The title name. */
	private String titleName;
	
	private String authorName;
	
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}



	/** The title id. */
	private int titleId;

	/** The subject id. */
	private int subjectId;

	/** The publisher id. */
	private int publisherId;

	/**
	 * Gets the publisher id.
	 *
	 * @return the publisherId
	 */
	public int getPublisherId() {
		return publisherId;
	}



	/**
	 * Sets the publisher id.
	 *
	 * @param publisherId the publisherId to set
	 */
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}



	/**
	 * Gets the title name.
	 *
	 * @return the titleName
	 */
	public String getTitleName() {
		return titleName;
	}



	/**
	 * Gets the title id.
	 *
	 * @return the titleId
	 */
	public int getTitleId() {
		return titleId;
	}



	/**
	 * Gets the subject id.
	 *
	 * @return the subjectId
	 */
	public int getSubjectId() {
		return subjectId;
	}



	/**
	 * Sets the title name.
	 *
	 * @param titleName the titleName to set
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}



	/**
	 * Sets the title id.
	 *
	 * @param titleId the titleId to set
	 */
	public void setTitleId(int titleId) {
		this.titleId = titleId;
	}



	/**
	 * Sets the subject id.
	 *
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  "[" + titleName + "\t" + titleId
				+ "\t" + subjectId + "\t" + publisherId
				+ "]";
	}	
}
