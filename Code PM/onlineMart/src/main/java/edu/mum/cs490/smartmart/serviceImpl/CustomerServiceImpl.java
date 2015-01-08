/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;


import edu.mum.cs490.smartmart.dao.ICredentialDAO;
import edu.mum.cs490.smartmart.dao.ICustomerDAO;
import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Role;
import edu.mum.cs490.smartmart.service.ICredentialService;
import edu.mum.cs490.smartmart.service.ICustomerService;
import edu.mum.cs490.smartmart.service.IEncryptionService;
import edu.mum.cs490.smartmart.service.INotificationService;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Komal
 */
public class CustomerServiceImpl implements ICustomerService {

    ICustomerDAO customerDAO;

    IEncryptionService encryptionService;
    
    ICredentialDAO credentialDAO;
    
    INotificationService notificationService;
    
    ICredentialService credentialService;

    public ICustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(ICustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public IEncryptionService getEncryptionService() {
        return encryptionService;
    }

    public void setEncryptionService(IEncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    public ICredentialDAO getCredentialDAO() {
        return credentialDAO;
    }

    public void setCredentialDAO(ICredentialDAO credentialDAO) {
        this.credentialDAO = credentialDAO;
    }

    public INotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void setCredentialService(ICredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addCustomer(Customer customer) {
        System.out.println("customer is" + customer);
//        System.out.println("inside impl:" + customer.getCredential().getPassword());
//        if(customer.getCredential().getPassword()!=null)
//        {
//        customer.getCredential().setPassword(encryptionService.getEncryptedPassword(customer.getCredential().getPassword()));
//        customer.getCredential().setRole(Role.CUSTOMER);
//        }
        System.out.println("m imp here");
        customerDAO.save(customer);
    }
    
//       @Transactional(propagation = Propagation.REQUIRED)
//    @Override
//    public boolean checkUserName(String userName) {
//        Credential cred=new Credential();
//        cred.setUsername(userName);
//        System.out.println("DAO is " + credentialDAO);
//        System.out.println("-----is " + credentialDAO.findByExample(cred,new String[]{}));
//        if (credentialDAO.findByExample(cred,new String[]{}) != null)
//        credentialDAO.getCredentialByUserName(userName) != null
//        {
//            return true;
//        }
//        return false;
//    }

        @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean checkUserName(String userName) {
//        if (credentialDAO. != null) {
        if(credentialService.getCredentialByUserName(userName) !=null)
        {
            return true;
        }
        return false;
    }

//    @Transactional(propagation = Propagation.REQUIRED)
//    @Override
//    public Users getUserByUsername(String username) {
//        List<Credential>  credential = credentialDAO.findAll(0, 10);
//        Credential cr = null;
//        for (Credential crd: credential)
//        {
//            if(crd.getUsername().equals(username))
//              cr= crd;
//        }
//
//        Users user = null;
//        if (cr != null) {
//            user = cr.getUser();
//
//        }
//        return user;
//    }
    
    
    
    
    
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Customer getCustomerById(Long id) {
        
        return customerDAO.findByPrimaryKey(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void disableCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public void notifyCustomer(Customer customer, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
