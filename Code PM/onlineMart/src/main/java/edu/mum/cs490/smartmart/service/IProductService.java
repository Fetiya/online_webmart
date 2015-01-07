/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.Vendor;
import java.util.List;

/**
 *
 * @author Kabiraj
 */
public interface IProductService {
    
     public List<Product> searchProductByName(String pname);
    
     public Product getProductDetailInfo(int id);
    
     public void addProduct(Product product);
     
     public void updateProduct(Product product);
     
     public Product getProduct(long id);
     
     public List<Product> getAllProducts();
     
     public List<Product> getProductByName(String name);

     public List<ProductCategory> getListOfCategory();

  
    public List<Vendor> getListOfVendor();

  
    public void deleteProduct(Product product);


    
   

 
    public List<Product> getProductByCategoryId(long categoryId);

    public List<Product> getProductByVendorCategoryId(Vendor v, ProductCategory c);

    public List<Product> getProductByVendor(Vendor v);
}
