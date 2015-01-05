/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.CustomerDAO;
import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.domain.Customer;

/**
 *
 * @author Komal
 */
public class CustomerDAOImpl extends GenericDAOImpl<Customer, Long> implements CustomerDAO {

    public CustomerDAOImpl() {
        super(Customer.class);
    }
    
}
