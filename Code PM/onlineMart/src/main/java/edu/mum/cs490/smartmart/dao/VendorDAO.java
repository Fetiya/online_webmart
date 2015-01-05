/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao;


import edu.mum.cs490.smartmart.domain.Vendor;
import java.util.List;

/**
 *
 * @author Stella
 */
public interface VendorDAO extends IGenericDAO<Vendor, Long>{
    
    public List<Vendor> getAllVendors();
    public List<Vendor> getAllPendingVendors();
    public Vendor getVendorById(Long id);
    public void update(Vendor vendor);
    public List<Vendor> getAllActiveVendor();
    
}
