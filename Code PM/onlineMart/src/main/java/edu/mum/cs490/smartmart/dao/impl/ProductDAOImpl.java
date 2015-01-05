/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.IProductDAO;
import edu.mum.cs490.smartmart.domain.Product;
import java.io.Serializable;

/**
 *
 * @author Fetiya
 */
public class ProductDAOImpl  extends GenericDAOImpl<Product, Long>implements IProductDAO{

    public ProductDAOImpl() {
        super(Product.class);
    }
  
    
}
