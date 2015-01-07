/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.IProductService;
import edu.mum.cs490.smartmart.service.IVendorService;
import edu.mum.cs490.smartmart.service.ProductCategoryService;
import edu.mum.cs490.smartmart.serviceImpl.VendorServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Fetiya
 */
@Controller
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ProductCategoryService categoryService;
    @Autowired
    private IVendorService vendor;

    public ProductCategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(ProductCategoryService categoryService) {
        this.categoryService = categoryService;
    }

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
        model.addAttribute("products", productService.getAllProducts());

        return "index";
    }

    @RequestMapping(value = "/productDetail", method = RequestMethod.GET)
    public String productDetails(Model model) {
        System.out.println("Controller");

        // List<Product> usr= userService.getAllUsers();
        // model.addAttribute("products",productService.getAllProducts());
        return "productDetail";
    }

    @RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
    public String searchProductByName() {;
        return "searchProduct";
    }

    @RequestMapping(value = "/searchProduct", method = RequestMethod.POST)
    public String searchProduct(RedirectAttributes re, Model model, @Valid String productName) {
        System.out.println("Produdtc Name : " + productName);
        List<Product> products = productService.getProductByName(productName);
        System.out.println(products.size());
        if (products.size() > 0) {  //searched product found           
            model.addAttribute("products", products);
            return "productResult";
        } else {
            re.addFlashAttribute("msgs", "Product not found, please try again");
            return "notFound";
        }
    }

    @RequestMapping(value = "/navigation", method = RequestMethod.GET)
    public String showNavigation(Model model) {
        model.addAttribute("categories", categoryService.getAllProductCategory());
        model.addAttribute("vendor", vendor.getAllVendors());
        return "navigation";
    }

    @RequestMapping(value = "getProductsByVendor/{vid}/{cid}", method = RequestMethod.GET)
    public String getProductByVendor(Model model, @PathVariable long vid, @PathVariable long cid) {
        Vendor v = vendor.getVendorById(vid);
        ProductCategory c = categoryService.getProductCategoryById(cid);
        List<Product> productList = productService.getProductByVendorCategoryId(v, c);
        model.addAttribute("productlist", productList);
        return "productByVendor";

    }

    @RequestMapping(value = " getProductByVendorOnly/{vid}", method = RequestMethod.GET)
    public String getProductByVendor(Model model, @PathVariable long vid) {
        Vendor v = vendor.getVendorById(vid);
        List<Product> productList = productService.getProductByVendor(v);
        model.addAttribute("productlist", productList);
        return "productByVendor";

    }

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public String VendorList(Model model) {
        List<Vendor> v = vendor.getAllVendors();
        model.addAttribute("vendorList", v);
        System.out.println(v.size());
        return "brands";
    }

}
