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
import java.util.List;
import org.hibernate.Query;
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

    @Override
    public List<ShoppingCartItem> getCustomerShoppingCart(Customer customer) {
       
        List<ShoppingCartItem> cartItems;
        Query query = getSf().getCurrentSession().createQuery("from ShoppingCartItem where customer=:customer");
        
        query.setParameter("customer", customer);
        
        cartItems=query.list();
        
        return cartItems;
    }
    
    
    @Override
    public void clearCustomerShoppingCart(Customer customer) {
        
        List<ShoppingCartItem> cartItems=getCustomerShoppingCart(customer);
        
      //  if (cart != null) {
            for(ShoppingCartItem cartItem: cartItems)
            {
                getSf().getCurrentSession().delete(cartItem);
               // cartItem.delete();
            }
        }
    
    
}
