/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.IProductDAO;
import edu.mum.cs490.smartmart.domain.Product;

import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.service.IProductService;
import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */
public class ProductServiceImpl implements IProductService{

    
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
import edu.mum.cs490.smartmart.dao.IProductCategoryDAO;
import edu.mum.cs490.smartmart.dao.ProductDAO;
import edu.mum.cs490.smartmart.dao.IVendorDAO;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.ProductService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Kabiraj
 */
public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;
    private IProductCategoryDAO productCategoryDAO;
    private IVendorDAO vendorDAO;

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public IVendorDAO getVendorDAO() {
        return vendorDAO;
    }

    public void setVendorDAO(IVendorDAO vendorDAO) {
        this.vendorDAO = vendorDAO;
    }
    
    

    public IProductCategoryDAO getProductCategoryDAO() {
        return productCategoryDAO;
    }

    public void setProductCategoryDAO(IProductCategoryDAO productCategoryDAO) {
        this.productCategoryDAO = productCategoryDAO;
    }
    
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addProduct(Product product) {
      
        
      try{
           productDAO.save(product);  
           
        }catch(Exception e){
            
        }
    }

    @Override
    public List<Product> getAllProducts() {
        
        List<Product> products= productDAO.findAll(0, 10);
        return products;

    }

    @Override
    public List<ProductCategory> getListOfCategory() {
        
        List<ProductCategory> categories= productCategoryDAO.findAll(0, 10);
        return categories;
    }

    @Override
    public List<Vendor> getListOfVendor() {
        
        List<Vendor> vendors=vendorDAO.findAll(0, 10);
        return vendors;
        
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Product getProduct(long id) {
       try{
           return productDAO.findByPrimaryKey(id);
        }catch(Exception e){
            return null;
        }
    }
    
    
    
}
