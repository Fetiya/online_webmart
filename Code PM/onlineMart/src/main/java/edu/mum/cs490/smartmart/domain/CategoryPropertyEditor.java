/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.domain;

import edu.mum.cs490.smartmart.service.IProductCategoryService;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Kabiraj
 */
public class CategoryPropertyEditor extends PropertyEditorSupport{
    
    private IProductCategoryService categoryService;
    
    public CategoryPropertyEditor(IProductCategoryService categoryService)
    {
        this.categoryService=categoryService;
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        int id=Integer.parseInt(text);
        ProductCategory category=categoryService.getProductCategoryById(id);
        setValue(category);
    }

}
