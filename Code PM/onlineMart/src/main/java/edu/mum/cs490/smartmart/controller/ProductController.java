/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Fetiya
 */
@Controller
public class ProductController {
    
    @Autowired
    private IProductService productService;

    public IProductService getProductService() {
        return productService;
    }

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }
    
    
    
    // take it to product controller???
   @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String initalHome(Model model) {
         System.out.println("Controller");
        
     // List<Product> usr= userService.getAllUsers();
     model.addAttribute("products",productService.getAllProducts());

        return "index";
    }
    
    
    @RequestMapping(value = "/productDetail", method = RequestMethod.GET)
    public String productDetails(Model model) {
         System.out.println("Controller");
        
     // List<Product> usr= userService.getAllUsers();
    // model.addAttribute("products",productService.getAllProducts());

        return "productDetail";
    }
    
    
}
