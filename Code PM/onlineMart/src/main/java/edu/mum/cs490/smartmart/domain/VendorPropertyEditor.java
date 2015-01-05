/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.domain;

import edu.mum.cs490.smartmart.service.ProductCategoryService;
import edu.mum.cs490.smartmart.service.VendorService;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Kabiraj
 */
public class VendorPropertyEditor extends PropertyEditorSupport {
    
    private VendorService vendorService;
  
    public VendorPropertyEditor(VendorService vendorService) {
        this.vendorService=vendorService;
        
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        int id=Integer.parseInt(text);
        Vendor vendor=vendorService.getVendorById(id);
        setValue(vendor);
    }

    
}
