/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.IProductDAO;
import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;

import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.IProductService;
import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */
public class ProductServiceImpl implements IProductService {

    IProductDAO productDAO;

    public IProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> searchProductByName(String pname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProductDetailInfo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProduct(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Product> getAllProducts() {

        return productDAO.findAll();
    }

    @Override
    public List<Product> getProductByName(String name) {
        System.out.println(" i m here at product service implementation");

        List<Product> products = productDAO.getProductByName(name);
        System.out.println(" i m here at product service implementation inside function");
        return products;

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Product> getProductByCategoryId(long categoryId) {
        List<Product> p = productDAO.getProductByCatId(categoryId);
        return p;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Product> getProductByVendorCategoryId(Vendor v, ProductCategory c) {
        List<Product> p = productDAO.getProductByVendorCategoryId(v, c);
        return p;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Product> getProductByVendor(Vendor v) {
        List<Product> p = productDAO.getProductByVendor(v);
        return p;
    }

}
