/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.VendorDAO;
import edu.mum.cs490.smartmart.domain.User;
import edu.mum.cs490.smartmart.domain.Vendor;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Stella
 */
@Transactional(propagation=Propagation.MANDATORY)
public class VendorDAOImpl extends GenericDAOImpl<User, Long> implements VendorDAO{
    private SessionFactory sessionFactory; 
  
    
        
     @Transactional(propagation = Propagation.SUPPORTS)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public VendorDAOImpl() {
        super(Vendor.class);
    }

    @Override
    public List<Vendor> getAllVendors() {
        List<Vendor> vendors =sessionFactory.getCurrentSession().createQuery("from Vendor").list();
        return vendors;
    }
    
    
}
