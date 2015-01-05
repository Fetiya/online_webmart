/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.ProductDAO;
import edu.mum.cs490.smartmart.domain.Product;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author Kabiraj
 */
@Transactional(propagation=Propagation.MANDATORY)
public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements ProductDAO {

    public ProductDAOImpl()
    {
        super(Product.class);
    }


    
}
