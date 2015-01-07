/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.IProductDAO;
import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.Vendor;
import java.io.Serializable;
import java.time.Clock;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */
public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements IProductDAO {

    public ProductDAOImpl() {
        super(Product.class);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Product> getProductByName(String name) {
        System.out.println("i m in product dao");
        List<Product> product;
        Query query = getSf().getCurrentSession().createQuery(" from Product p where p.name=name");
        //  query.setParameter("name", name);

        System.out.println("hereeee" + query.list());
        //query.setString("theName",name);
        product = query.list();
        System.out.println("i m in product dao adter r");
        return product;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Product> getProductByCatId(long categoryId) {
        List<Product> product;
        Query query = getSf().getCurrentSession().createQuery(" from Product p where p.productCategory_id=categoryId");
        product = query.list();
        return product;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Product> getProductByVendorCategoryId(Vendor v, ProductCategory c) {
        List<Product> product;

        Query query = getSf().getCurrentSession().createQuery("select p  from Product p where p.vendor=:v AND p.productCategory=:c");
        query.setParameter("v", v);
        query.setParameter("c", c);
        product = query.list();
        System.out.println("size of product Array: " + product.size());
        return product;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Product> getProductByVendor(Vendor v) {
        List<Product> product;
        Query query = getSf().getCurrentSession().createQuery("select p  from Product p where p.vendor=:v ");
        query.setParameter("v", v);
        product = query.list();
        System.out.println("size of product Array: " + product.size());
        return product;
    }

    @Override
    public List<Product> getAllAvailalbleProducts() {
       
    Query query=getSf().getCurrentSession().createQuery("select p from Product p where p.quantity > 0");
    
    List<Product> products=query.list();
    
    return products;
    
    
    }

}
