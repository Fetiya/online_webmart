/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.CategoryPropertyEditor;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorPropertyEditor;
import edu.mum.cs490.smartmart.service.ProductCategoryService;
import edu.mum.cs490.smartmart.service.ProductService;
import edu.mum.cs490.smartmart.service.VendorService;
import java.beans.PropertyEditor;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Kabiraj
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;
    
    @Autowired
    private VendorService vendorService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(ProductCategory.class, new CategoryPropertyEditor(productCategoryService));
        binder.registerCustomEditor(Vendor.class, new VendorPropertyEditor(vendorService));
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(Product product, @RequestParam("file") MultipartFile file) {
        
        String view = "redirect:/products";
        try {
                product.setImage(file.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        System.out.println("product iname is"  + product.getName());
        productService.addProduct(product);
        return view;
    }

    @RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
    public String insertProduct(@ModelAttribute("product") Product product, Model model) {

        model.addAttribute("categories", productService.getListOfCategory());
        model.addAttribute("vendors", productService.getListOfVendor());
        return "insertProduct";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAll(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        return "viewProducts";
    }

    @RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
    public String getAllProducts(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        return "viewProducts";
    }
    
    
    
    @RequestMapping(value = "/productImage/{id}", method = RequestMethod.GET)
    public void getProductImage(Model model, @PathVariable int id, HttpServletResponse response) {
        try {
            Product p = productService.getProduct(id);
            if (p != null) {
                OutputStream out = response.getOutputStream();
                out.write(p.getImage());
                System.out.println("================="+Arrays.toString(p.getImage()));
                response.flushBuffer();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
