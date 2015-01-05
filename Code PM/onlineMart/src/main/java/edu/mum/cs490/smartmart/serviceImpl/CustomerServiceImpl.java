/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.CustomerDAO;
import edu.mum.cs490.smartmart.dao.RoleDAO;
import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Role;
import edu.mum.cs490.smartmart.service.CustomerService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Komal
 */
public class CustomerServiceImpl implements CustomerService {

    CustomerDAO customerDAO;

    RoleDAO roleDAO;

    EncryptionServiceImpl encryptionServiceImpl;

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
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
    public void addCustomer(Customer customer) {
        customer.getCredential().setPassword(encryptionServiceImpl.getEncryptedPassword(customer.getCredential().getPassword()));
        List<Role> roles = roleDAO.findAll(0, 10);

        for (Role role : roles) {
            if (role.getRole().equalsIgnoreCase("user")) {
                customer.setRole(role);
            }
        }
        customerDAO.save(customer);
    }

}
