/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.IVendorDAO;
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
public class VendorDAOImpl extends GenericDAOImpl<Vendor, Long> implements IVendorDAO{
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

    @Override
    public List<Vendor> getAllPendingVendors() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vendor getVendorById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Vendor vendor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vendor> getAllActiveVendor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
