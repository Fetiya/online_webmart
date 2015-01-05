/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;

import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Fetiya
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/viewUsers", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        // System.out.println("Controller"+id);

        List<Users> usr = userService.getAllUsers();
        model.addAttribute("users", userService.getAllUsers());

        return "viewUsers";
    }

}
