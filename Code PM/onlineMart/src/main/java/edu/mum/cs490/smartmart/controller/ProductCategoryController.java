/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.service.IProductCategoryService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dipika
 */
@Controller
public class ProductCategoryController {

    @Autowired
    private IProductCategoryService categoryService;

    public IProductCategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(IProductCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/addProductCategory", method = RequestMethod.GET)
    public String addCategoryView(@ModelAttribute("category") ProductCategory category) {
        return "addProductCategory";
    }

    @RequestMapping(value = "/addProductCategory", method = RequestMethod.POST)
    public String addcategory(@Valid ProductCategory productCategory, BindingResult result) {
        String view = "redirect:/viewCategory";
        if (!result.hasErrors()) {
            try {
                categoryService.addProductCategory(productCategory);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            return "addProductCategory";
        }
        return view;
    }

    @RequestMapping(value = "/viewCategory", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        // System.out.println("Controller"+id);
        List<ProductCategory> category = categoryService.getAllProductCategory();
        model.addAttribute("categories", category);

        return "productCategory";
    }

    @RequestMapping(value = "/productCategoryEdit/{id}", method = RequestMethod.GET)
    public String getProduct(Model model, @PathVariable long id) {
        model.addAttribute("productCategory", categoryService.getProductCategoryById(id));
        return "editProductCategory";
    }

    @RequestMapping(value = "/editCategory", method = RequestMethod.POST)
    public String updateProduct(@Valid ProductCategory category, BindingResult result) {
        if (!result.hasErrors()) {
            try {
                System.out.println("Cat Id :" + category.getId());
                categoryService.updateProductCategory(category);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return "redirect:/products";
        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println(err.getField() + ": " + err.getDefaultMessage());
            }
            return "editProduct";
        }
    }
    
    
    @RequestMapping(value = "/productCategoryDelete/{id}", method = RequestMethod.GET)
    public String deleteProduct(Model model, @PathVariable long id) {
        ProductCategory c = categoryService.getProductCategoryById(id);
        categoryService.deleteCategory(c);
        return "redirect:/viewCategory";
    }

   
    


}
