/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.ShoppingCartItem;
import edu.mum.cs490.smartmart.service.ICustomerService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        return "customerRegisteration";
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String add(@Valid Customer customer, BindingResult result, RedirectAttributes flashAttr) {

        String view = "redirect:/";
        if (!result.hasErrors()) {
            customerService.addCustomer(customer);
            flashAttr.addFlashAttribute("successfulSignup", "Customer signed up succesfully. please  log in to proceed");

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
            }
            view = "addCustomer";
        }
        return view;
    }

    
    
    
    @RequestMapping(value = "/cart/delete/{id}", method = RequestMethod.GET)
    public String deleteCartItem(@PathVariable Long id, Model model, HttpSession session) {

        ShoppingCartItem item = shoppingCartService.getShoppingCart(id);
        
        //use this after login is done
        //Customer customer = (Customer) session.getAttribute("loggedUser");
          Customer customer= customerService.getCustomerById(Long.valueOf(String.valueOf(1)));
        customer.getShoppingCart().remove(item);

        shoppingCartService.deleteShoppingCartItem(item);

        //cartService.updateCart(customer.getShoppingCart());

        //cartService.deleteShoppingCartItem(customer.getShoppingCart(), item);
        return "redirect:/cart";
    }
}
