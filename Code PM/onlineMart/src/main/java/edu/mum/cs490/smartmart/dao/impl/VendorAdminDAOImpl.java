/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.IVendorAdminDAO;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorAdmin;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author senai
 */
@Transactional(propagation = Propagation.SUPPORTS)
public class VendorAdminDAOImpl extends GenericDAOImpl<VendorAdmin, Long> implements IVendorAdminDAO  {

    public VendorAdminDAOImpl() {
        super(VendorAdmin.class);
    }

    
}
