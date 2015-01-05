/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.service.CustomerService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Komal
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        return "customerRegisteration";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String add(@Valid Customer customer, BindingResult result, RedirectAttributes flashAttr) {

        String view = "redirect:/";
        if (!result.hasErrors()) {
            customerService.addCustomer(customer);
            flashAttr.addFlashAttribute("successfulSignup", "Venodr signed up succesfully. please  log in to proceed");

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
            }
            view = "addCustomer";
        }
        return view;
    }

}
