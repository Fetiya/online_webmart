/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.domain;

import edu.mum.cs490.smartmart.service.IProductCategoryService;
import edu.mum.cs490.smartmart.service.IVendorService;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Kabiraj
 */
public class VendorPropertyEditor extends PropertyEditorSupport {
    
    private IVendorService vendorService;
  
    public VendorPropertyEditor(IVendorService vendorService) {
        this.vendorService=vendorService;
        
    }
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException
    {
        long id=Long.parseLong(text);
        Vendor vendor=vendorService.getVendorById(id);
        
        setValue(vendor);
    }

    
}
