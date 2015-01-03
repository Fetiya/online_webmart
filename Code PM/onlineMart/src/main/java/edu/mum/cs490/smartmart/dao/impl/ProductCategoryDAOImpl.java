/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.ProductCategoryDAO;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dipika
 */
@Transactional(propagation = Propagation.MANDATORY)
public class ProductCategoryDAOImpl extends GenericDAOImpl<ProductCategory, Long> implements ProductCategoryDAO {

    

    public ProductCategoryDAOImpl() {
        super(ProductCategory.class);
    }

    

   

    

}
