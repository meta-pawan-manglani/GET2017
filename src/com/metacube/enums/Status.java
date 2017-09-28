package com.metacube.enums;

/**
 * The Enum Status.
 *
 * This is used to give status of different different operations
 *
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
public enum Status {

	/**
	 * The NOT found. If entity not found
	 */
	NOT_Found,
	/**
	 * The Found. If entity found
	 */
	Found,
	/**
	 * The Duplicate. In case if Entity is Duplicate
	 */
	Duplicate,
	/**
	 * The Added. In case if entity is added
	 */
	Added,
	/**
	 * The Error_Occured ,In case of Error
	 */
	Error_Occured,
	/**
	 * The Success In case of Successful operation
	 */
	Success
}
