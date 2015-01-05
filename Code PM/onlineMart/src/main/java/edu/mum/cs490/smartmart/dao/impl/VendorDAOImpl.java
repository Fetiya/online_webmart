/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.VendorDAO;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorStatus;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Stella
 */
@Transactional(propagation=Propagation.SUPPORTS)
public class VendorDAOImpl extends GenericDAOImpl<Vendor, Long> implements VendorDAO{
 
 
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
        List<Vendor> vendors=getSf().getCurrentSession().createQuery("from Vendor").list();
        List<Vendor> pendingVendors=new ArrayList();
        for (Vendor vendor : vendors) {
                if (vendor.getStatus()==VendorStatus.PENDING) {
                    pendingVendors.add(vendor);
                }
            }
        return pendingVendors;
    }

    @Override
    public Vendor getVendorById(Long id) {
                  
        Criteria criteria = getSf().getCurrentSession().createCriteria(Vendor.class);
       
        criteria.add(Restrictions.eq("id", id));
    
        return (Vendor) criteria.uniqueResult();
         
    }
//        Query query = getSf().getCurrentSession().createQuery("Select distinct v from Vendor v where v.id=:vendorid");
//         Vendor vendor=(Vendor)query.setLong("vendorid", id);
//        //Vendor vendor=(Vendor)getSf().getCurrentSession().createQuery("Select v from Vendor v where v.id:id");
//        return vendor;
    

    @Override
    public void update(Vendor vendor) {
        getSf().getCurrentSession().update(vendor);
    }

    @Override
    public List<Vendor> getAllActiveVendor() {
      List<Vendor> vendors=getSf().getCurrentSession().createQuery("from Vendor").list();
        List<Vendor> activeVendors=new ArrayList();
        for (Vendor vendor : vendors) {
                if (vendor.getStatus()==VendorStatus.ACTIVE) {
                    activeVendors.add(vendor);
                }
            }
        return activeVendors;
    }

    
    
}
