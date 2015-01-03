/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.VendorDAO;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.domain.Vendor;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Stella
 */
@Transactional(propagation=Propagation.SUPPORTS)
public class VendorDAOImpl extends GenericDAOImpl<Users, Long> implements VendorDAO{
 
 
    public VendorDAOImpl() {
        super(Vendor.class);
    }

    @Override
    public List<Vendor> getAllVendors() {
        List<Vendor> vendors =getSf().getCurrentSession().createQuery("from Vendor").list();
        for(Vendor v:vendors){
             System.out.println("company name"+ v.getCompanyName());
        }
       
        return vendors;
    }

    @Override
    public List<Vendor> getAllPendingVendors() {
        List<Vendor> pendingVendors=getSf().getCurrentSession().createQuery("Select v from Vendor v where v.status=:pending").list();
        return pendingVendors;
    }
    
    
}
