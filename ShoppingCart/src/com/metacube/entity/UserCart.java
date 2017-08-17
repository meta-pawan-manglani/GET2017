/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.entity;

import java.util.ArrayList;
import java.util.Map;

/**
 * The Class UserCart.
 * 
 * Order Bean
 * 
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
public class UserCart implements BaseEntity{
	
	/** The id. */
	private int id;
	
	/** The order detail. store the id of product and it's corresponding quantity*/
	private Map<String,Integer> orderDetail;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the order detail.
	 *
	 * @return the order detail map
	 */
	public Map<String,Integer> getOrderDetail() {
		return orderDetail;
	}

	/**
	 * Sets the order detail.
	 *
	 * @param orderDetail the order detail a map which store the id of product and it's corresponding quantity
	 */
	public void setOrderDetail(Map<String,Integer> orderDetail) {
		this.orderDetail = orderDetail;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
