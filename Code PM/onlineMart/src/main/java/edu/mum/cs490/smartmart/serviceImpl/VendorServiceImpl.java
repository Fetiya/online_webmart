/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.domain.Role;
import edu.mum.cs490.smartmart.domain.VendorStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.cs490.smartmart.dao.IVendorDAO;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.IEncryptionService;
import edu.mum.cs490.smartmart.service.IVendorService;
import java.util.List;

/**
 *
 * @author Komal
 */
public class VendorServiceImpl implements IVendorService {

    IVendorDAO vendorDAO;

    IEncryptionService encryptionService;

    public IVendorDAO getVendorDAO() {
        return vendorDAO;
    }

    public void setVendorDAO(IVendorDAO vendorDAO) {
        this.vendorDAO = vendorDAO;
    }

    public IEncryptionService getEncryptionService() {
        return encryptionService;
    }

    public void setEncryptionService(IEncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addVendor(Vendor vendor) {
        vendor.getVendorAdmin().getCredential().setPassword(encryptionService.getEncryptedPassword(vendor.getVendorAdmin().getCredential().getPassword()));
        vendor.getVendorAdmin().getCredential().setRole(Role.VENDORADMIN);
        vendor.setStatus(VendorStatus.PENDING);
        vendor.getVendorAdmin().setVendor(vendor);
        vendorDAO.save(vendor);
    }

    @Override
    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = vendorDAO.getAllVendors();
        return vendors;
    }
}
