/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Address;
import edu.mum.cs490.smartmart.domain.Credential;
import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.service.ICustomerService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Komal
 */
public class GuestController {
    @Autowired
    ICustomerService customerService;

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }
    
  @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public String addCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        model.addAttribute("customer", customer);
//        if(customer!=null)
        return "customerRegisteration";
//        else
//        {
//            System.out.println("error is here");
//            return "addressRegisteration";
//        }

    }

    @RequestMapping(value = "/addGuest", method = RequestMethod.GET)
    public String addAddress(@ModelAttribute("address") Address address, Model model) {
        model.addAttribute("address", address);
        return "guestRegisteration";
    }

    @RequestMapping(value = "/addGuest", method = RequestMethod.POST)
    public String addTest(@Valid Address address, BindingResult result, HttpSession session) {

        String view = "redirect:/addGuest";

        if (!result.hasErrors()) {

            session.setAttribute("address", address);

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
            }
            view = "guestRegisteration";
        }
        return view;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String add(@Valid Customer customer, BindingResult result, HttpSession session, Model model) {

        String view = "redirect:/";

        if (!result.hasErrors()) {
//            if(customer.getAddress()==null)
            System.out.println("Customer object is:" + customer);
            System.out.println("Customer :" + customer.getFirstName());
            Credential credential = (Credential) session.getAttribute("credential");
            Address address = (Address) session.getAttribute("address");
            customer.setCredential(credential);
            customer.setAddress(address);
//                 cust = customer;   
            customerService.addCustomer(customer);
            session.removeAttribute("credential");
            session.removeAttribute("address");

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
            }
            view = "customerRegisteration";
        }
        return view;
    }

    @RequestMapping(value = "/addCredential", method = RequestMethod.GET)
    public String addCredential(@ModelAttribute("credential") Credential credential) {
//        credential
        return "addCredential";
    }

 
}
