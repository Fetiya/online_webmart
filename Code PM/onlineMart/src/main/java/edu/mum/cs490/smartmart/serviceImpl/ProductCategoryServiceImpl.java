/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.ProductCategoryDAO;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.service.ProductCategoryService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dipika
 */
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private ProductCategoryDAO productCategoryDAO;

    public ProductCategoryDAO getProductCategoryDAO() {
        return productCategoryDAO;
    }

    public void setProductCategoryDAO(ProductCategoryDAO productCategoryDAO) {
        this.productCategoryDAO = productCategoryDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addProductCategory(ProductCategory category) {
        try {
            productCategoryDAO.save(category);
        } catch (Exception e) {
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<ProductCategory> getAllProductCategory() {
        List<ProductCategory> category = productCategoryDAO.findAll(0, 10);
        return category;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateProductCategory(ProductCategory category) {
        try {
            productCategoryDAO.save(category);
        } catch (Exception e) {
        }
    }

   @Transactional(propagation = Propagation.REQUIRED)
   @Override
    public ProductCategory getProductCategoryById(long id) {
        
        try {
            return productCategoryDAO.findByPrimaryKey(id);
        } catch (Exception e) {
            return null;
        }
    }

     @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteCategory(ProductCategory category) {
        try {
            productCategoryDAO.delete(category);
        } catch (Exception e) {
        }
    }
   
}
