/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.ProductCategory;
import java.util.List;

/**
 *
 * @author dipika
 */
public interface ProductCategoryService {
    public void addProductCategory(ProductCategory category);
    public List<ProductCategory> getAllProductCategory();
    public void updateProductCategory(ProductCategory category);
    public ProductCategory getProductCategoryById(long id);
    public void deleteCategory(ProductCategory category);
}
