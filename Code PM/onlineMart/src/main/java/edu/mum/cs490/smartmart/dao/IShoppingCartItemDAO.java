/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.cs490.smartmart.dao;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.ShoppingCartItem;
import java.util.List;

/**
 *
 * @author Senai
 */
public interface IShoppingCartItemDAO   extends IGenericDAO<ShoppingCartItem, Long>{
 
    
  public List<ShoppingCartItem>   getCustomerShoppingCart(Customer customer);
  
  public void clearCustomerShoppingCart(Customer customer);
  public ShoppingCartItem getShoppingCartByProduct(Long id);
     
}
