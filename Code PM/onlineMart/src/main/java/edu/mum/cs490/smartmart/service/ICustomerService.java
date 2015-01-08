/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.ShoppingCartItem;
import edu.mum.cs490.smartmart.domain.Users;
import java.util.List;

/**
 *
 * @author Senai
 */
public interface ICustomerService {
    
    public void addCustomer(Customer customer);
    
    public Customer getCustomerById(Long id);
    
    public List<Customer> getAllCustomers();
    
    public void disableCustomer(Customer customer);
    
    public void updateCustomer(int id,Customer customer);
    
//    public Users getUserByUsername(String username);
    
    public boolean checkUserName(String userName); 
    
    public void notifyCustomer(Customer customer, String message);
    
   
}
