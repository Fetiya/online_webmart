/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.RoleDAO;
import edu.mum.cs490.smartmart.domain.Role;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Komal
 */

@Transactional(propagation=Propagation.MANDATORY)
public class RoleDAOImpl extends GenericDAOImpl<Role, Long> implements RoleDAO {

    public RoleDAOImpl() {
        super(Role.class);
    }
    
}
