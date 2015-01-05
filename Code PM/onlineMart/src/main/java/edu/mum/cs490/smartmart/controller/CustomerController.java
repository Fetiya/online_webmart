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
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCustomerCart(Model model) {
        // System.out.println("Controller"+id);

        Customer customer = new Customer();
        Long id = Long.valueOf(String.valueOf(1));

        customer = customerService.getCustomerById(id);

        System.out.println(" custmer name is" + customer.getFirstName());

    // List<ShoppingCartItem> cartItems= shoppingCartService.findAll();
        // model.addAttribute("cartItems",shoppingCartService.getCustomerShoppingCart(customer));
        List<ShoppingCartItem> cartItems = shoppingCartService.findAll();
        double total = 0;
        for (ShoppingCartItem i : cartItems) {
            total += i.getProduct().getPrice() * i.getQuantity();
        }
        model.addAttribute("cartItems", cartItems);

        model.addAttribute("totalPrice", total);

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
