/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.IAddressDAO;
import edu.mum.cs490.smartmart.domain.Address;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author seadaghish
 */

@Transactional(propagation=Propagation.MANDATORY)
public class AddressDAOImpl extends GenericDAOImpl<Address, Long> implements IAddressDAO{

    public AddressDAOImpl() {
        super(Address.class);
    }
    
}
