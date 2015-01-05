/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.RoleDAO;
import edu.mum.cs490.smartmart.dao.VendorDAO;
import edu.mum.cs490.smartmart.domain.Role;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorStatus;
import edu.mum.cs490.smartmart.service.VendorService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Komal
 */
public class VendorServiceImpl implements VendorService {

    VendorDAO vendorDAO;

    EncryptionServiceImpl encryptionServiceImpl;

    RoleDAO roleDAO;

    public VendorDAO getVendorDAO() {
        return vendorDAO;
    }

    public void setVendorDAO(VendorDAO vendorDAO) {
        this.vendorDAO = vendorDAO;
    }

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public EncryptionServiceImpl getEncryptionServiceImpl() {
        return encryptionServiceImpl;
    }

    public void setEncryptionServiceImpl(EncryptionServiceImpl encryptionServiceImpl) {
        this.encryptionServiceImpl = encryptionServiceImpl;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addVendor(Vendor vendor) {
        vendor.setStatus(VendorStatus.PENDING);
        vendor.getVendorAdmin().getCredential().setPassword(encryptionServiceImpl.getEncryptedPassword(vendor.getVendorAdmin().getCredential().getPassword()));
        List<Role> roles = roleDAO.findAll(0, 10);

        for (Role role : roles) {
            if (role.getRole().equalsIgnoreCase("vendor")) {
                vendor.getVendorAdmin().setRole(role);
            }
        }
        vendor.getVendorAdmin().setVendor(vendor);
        vendorDAO.save(vendor);
    }
}
