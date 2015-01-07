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
import edu.mum.cs490.smartmart.service.INotificationService;
import edu.mum.cs490.smartmart.service.IVendorService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Komal
 */
public class VendorServiceImpl implements IVendorService {

    IVendorDAO vendorDAO;

    IEncryptionService encryptionService;
    
    INotificationService notificationService;

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

    public INotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addVendor(Vendor vendor) {
        vendor.getVendorAdmin().getCredential().setPassword(encryptionService.getEncryptedPassword(vendor.getVendorAdmin().getCredential().getPassword()));
        vendor.getVendorAdmin().getCredential().setRole(Role.VENDORADMIN);
//        vendor.getVendorAdmin().setCredential(credential);
//        vendor.getVendorAdmin().setAddress(address);
        vendor.setStatus(VendorStatus.PENDING);
        vendor.getVendorAdmin().setVendor(vendor);
        vendorDAO.save(vendor);
    }

    @Override
    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = vendorDAO.getAllVendors();
        return vendors;
    }

//    @Override
//    public Vendor getVendorById(Long id) {
//        Vendor vendor=vendorDAO.getVendorById(id);
//        return vendor;
//    }

//    @Override
//    public void update(Vendor vendor) {
//        vendorDAO.update(vendor);  
//    }
//
//    @Override
//    public List<Vendor> getAllPendingVendors() {
//         List<Vendor>vendors=vendorDAO.getAllPendingVendors();
//         return vendors;
//    }
//
//    @Override
//    public List<Vendor> getAllActiveVendor() {
//        List<Vendor>activeVendors=vendorDAO.getAllActiveVendor();
//        return activeVendors;
//    }
    
  

    @Override
    public void update(Vendor vendor) {
         vendorDAO.update(vendor);
    }

    @Override
    public List<Vendor> getAllPendingVendors() {
             List<Vendor>vendors=vendorDAO.getAllPendingVendors();
         return vendors;
    }

    @Override
    public List<Vendor> getAllActiveVendor() {
      List<Vendor>activeVendors=vendorDAO.getAllActiveVendor();
        return activeVendors;
    }

    @Override
    public Vendor getVendorById(Long id) {
        Vendor vendor=vendorDAO.getVendorById(id);
        return vendor;
    }
}
