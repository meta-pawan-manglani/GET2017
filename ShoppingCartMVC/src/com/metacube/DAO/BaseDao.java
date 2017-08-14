/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metacube.DAO;
import com.metacube.entity.BaseEntity;
import java.util.List;

/**
 * The Interface BaseDao.
 *
 *This DAO is the super DAO 
 * @param <T> the generic type
 * 
 * @author Pawan Manglani
 * @version 1.1 14-Aug-2017
 */
public interface BaseDao<T extends BaseEntity> {
    
    /**
     * Gets the all product.
     *
     * @param <Product> the generic type
     * @return the list containing  all product
     */
    public <Product> List<T> getAllProduct();
   
   /**
    * Searchproduct.
    *
    * @param id the id
    * @return the t
    */
   public <Product> T searchproduct(String id);
}
