/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Address;
import edu.mum.cs490.smartmart.domain.Credential;
import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Role;
import edu.mum.cs490.smartmart.domain.ShoppingCartItem;
import edu.mum.cs490.smartmart.service.ICustomerService;
import edu.mum.cs490.smartmart.service.IEncryptionService;
import edu.mum.cs490.smartmart.service.IShoppingCartService;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Fetiya
 */
@Controller
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @Autowired
    IShoppingCartService shoppingCartService;

    @Autowired
    IEncryptionService encryptionService;



    public ICustomerService getCustomerService() {
        return customerService;
    }

    public IShoppingCartService getShoppingCartService() {
        return shoppingCartService;
    }

    public void setShoppingCartService(IShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        // System.out.println("Controller"+id);

//        List<User> usr= userService.getAllUsers();
//      model.addAttribute("users",userService.getAllUsers());
        return "login";
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

    @RequestMapping(value = "/addAddress", method = RequestMethod.GET)
    public String addAddress(@ModelAttribute("address") Address address, Model model) {
        model.addAttribute("address", address);
        return "addressRegisteration";
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public String addTest(@Valid Address address, BindingResult result, HttpSession session) {

        String view = "redirect:/addCustomer";

        if (!result.hasErrors()) {

            session.setAttribute("address", address);

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
            }
            view = "addressRegisteration";
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

    @RequestMapping(value = "/addCredential", method = RequestMethod.POST)
    public String addCredential(@Valid Credential credential, BindingResult result, HttpSession session) {
        String view = "redirect:/addAddress";
        //dumb fix
        boolean used = customerService.checkUserName(credential.getUsername());
        if (used) {
            FieldError f = new FieldError("credential", "userName", credential.getUsername(), false, null, null, "Username : " + credential.getUsername() + " already in use");
            result.addError(f);
        }
        if (!result.hasErrors()) {
            Customer c = (Customer) session.getAttribute("loggedUser");
            credential.setRole(Role.CUSTOMER);
            credential.setPassword(encryptionService.getEncryptedPassword(credential.getPassword()));
            credential.setActive(true);
            session.setAttribute("credential", credential);

        } else {
            view = "addCredential";
        }
        return view;
    }

   
}
