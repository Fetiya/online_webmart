/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.RoleDAO;
import edu.mum.cs490.smartmart.domain.Role;
import edu.mum.cs490.smartmart.service.RoleService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Komal
 */
public class RoleServiceImpl implements RoleService {

    RoleDAO roleDAO;

    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = roleDAO.findAll(0, 10);
        return roles;

    }
}
