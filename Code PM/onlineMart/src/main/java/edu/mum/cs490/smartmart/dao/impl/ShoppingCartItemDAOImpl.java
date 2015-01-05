/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.IShoppingCartItemDAO;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.ShoppingCartItem;
import edu.mum.cs490.smartmart.domain.Users;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */
@Transactional(propagation=Propagation.MANDATORY)
public class ShoppingCartItemDAOImpl extends GenericDAOImpl<ShoppingCartItem, Long> implements IShoppingCartItemDAO {
   
    
   public ShoppingCartItemDAOImpl() {
     
    super(ShoppingCartItem.class);
 }
}
