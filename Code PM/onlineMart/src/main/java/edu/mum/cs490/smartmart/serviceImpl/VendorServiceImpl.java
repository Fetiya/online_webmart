/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.VendorDAO;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.VendorService;
import java.util.List;

/**
 *
 * @author Stella
 */
public class VendorServiceImpl implements VendorService{
    
    
    VendorDAO vendorDAO;

    public VendorDAO getVendorDAO() {
        return vendorDAO;
    }

    public void setVendorDAO(VendorDAO vendorDAO) {
        this.vendorDAO = vendorDAO;
    }
    
    

    @Override
    public List<Vendor> getAllVendors() {
        List<Vendor>vendors=vendorDAO.getAllVendors();
        return vendors;
    }
    
}
