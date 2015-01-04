/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import java.util.List;

/**
 *
 * @author Kabiraj
 */
public interface ProductService {
    
    public void addProduct(Product product);
    public List<ProductCategory> getListOfCategory();
    public List<Product> getAllProducts();
    
}
