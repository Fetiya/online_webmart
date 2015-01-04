/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Kabiraj
 */
@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping(value="/addProduct", method=RequestMethod.POST )
    public String addProduct(Product product)
    {
       String view = "redirect:/products";
       productService.addProduct(product);
       return view;
    }
    
    
    @RequestMapping(value="/insertProduct", method=RequestMethod.GET )
    public String insertProduct(Model model)
    {
      
       model.addAttribute("categories", productService.getListOfCategory());
       return "insertProduct";
    }
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAll(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        return "viewProducts";
    }
    
    @RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        
       // List<Product> pro= productService.getAllProducts();
        model.addAttribute("products",productService.getAllProducts());
        return "viewProducts";
    }
    
}
