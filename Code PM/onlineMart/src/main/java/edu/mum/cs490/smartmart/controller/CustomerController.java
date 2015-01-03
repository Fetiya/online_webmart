/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;


import edu.mum.cs490.smartmart.service.CustomerService;
import edu.mum.cs490.smartmart.service.ICustomerService;
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
public class CustomerController {
  
//    @Autowired
//   ICustomerService customerService;
//
//    public ICustomerService getCustomerService() {
//        return customerService;
//    }
//
//    public void setCustomerService(ICustomerService customerService) {
//        this.customerService = customerService;
//    }

  

 
    
     @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCustomerCart(Model model) {
        // System.out.println("Controller"+id);

 //   model.addAttribute("users",customerService.getAllUsers());

        return "cart";
    }
   
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkOut(Model model) {
        // System.out.println("Controller"+id);
        
//        List<User> usr= userService.getAllUsers();
//      model.addAttribute("users",userService.getAllUsers());

        return "checkout";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        // System.out.println("Controller"+id);
        
//        List<User> usr= userService.getAllUsers();
//      model.addAttribute("users",userService.getAllUsers());

        return "login";
    }
}
