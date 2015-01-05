/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Role;
import edu.mum.cs490.smartmart.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Komal
 */
@Controller
public class RoleController {
    
    @Autowired
    RoleService roleService;

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
    
      @RequestMapping(value = "/viewRoles", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        // System.out.println("Controller"+id);

        List<Role> usr = roleService.getAllRoles();
        model.addAttribute("users", roleService.getAllRoles());

        return "viewRoles";
    }
}
