/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;


import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Users;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Kabiraj
 */
@Controller
public class guestRegistrationController {
    
        @RequestMapping(value = "/guestRegistration", method = RequestMethod.GET)
    public String guestRegistration(@ModelAttribute("customer") Customer customer) {
        
        return "guestRegistration";
    }
    
    
            
    @RequestMapping(value = "/checkOutSelection", method = RequestMethod.GET)
    public String runCheckoutSelectionPage(@ModelAttribute("checkout") Customer customer) {
        
        return "checkOutSelection";
    }
    
    @RequestMapping(value = "/guestRegistration", method = RequestMethod.POST)
    public String addGuest(Customer customer, HttpSession session) {
        session.setAttribute("guestUser", customer);
        
        System.out.println("name :++++++++++++++++++++" +customer.getFirstName());
        System.out.println("City:====================="+customer.getAddress().getCity());
        System.out.println("Username:=========++++============"+customer.getCredential().getUsername());
     
        return "redirect:checkout";
    }
    
//    @RequestMapping(value = "/guestResult")
//    public String getResult(Model model,HttpSession session) {
//        model.addAttribute("guest", session.getAttribute("guestUser"));
//        return "checkout";
//    }
    
    
    
    
    
    
}
