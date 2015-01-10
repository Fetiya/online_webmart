/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.cs490.smartmart.dao;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.report.entity.ProductSales;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Senai
 */
public interface IProductDAO   extends IGenericDAO<Product, Long>{
     public List<Product> getProductByName(String name);
     public List<Product> getProductByCatId(long categoryId );
     public List<Product> getProductByVendorCategoryId(Vendor v, ProductCategory c);
     
     public List<Product> getProductByVendor(Vendor v);
     public List<ProductSales> getPrductsSalesByVendor(long vendorId);
     
     public List<Product> getAllAvailalbleProducts();
     
}
