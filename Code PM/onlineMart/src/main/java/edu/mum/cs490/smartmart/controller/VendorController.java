/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.SubscriptionRule;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.SubscriptionRuleService;
import edu.mum.cs490.smartmart.service.VendorService;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class VendorController {
List<SubscriptionRule> subscriptionRule;
    @Autowired
    private VendorService vendorService;

    @Autowired
    private SubscriptionRuleService subscriptionRuleService;

    public VendorService getVendorService() {
        return vendorService;
    }

    public void setVendorService(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    public SubscriptionRuleService getSubscriptionRuleService() {
        return subscriptionRuleService;
    }

    public void setSubscriptionRuleService(SubscriptionRuleService subscriptionRuleService) {
        this.subscriptionRuleService = subscriptionRuleService;
    }

    @RequestMapping(value = "/addVendor", method = RequestMethod.GET)
    public String addVendor(@ModelAttribute("vendor") Vendor vendor, Model model)
//     public String addVendor(Model model)
     {
//        vendor.setCredential((Credential) session.getAttribute("credential"));
        System.out.println("hello signup");

        subscriptionRule= subscriptionRuleService.getAllSubscriptionRules();
        model.addAttribute("subscriptionRule",subscriptionRuleService.getAllSubscriptionRules());
        return "vendorRegisteration";
    }

    @RequestMapping(value = "/addVendor", method = RequestMethod.POST)
    public String add(@Valid Vendor vendor, BindingResult result, HttpSession session, RedirectAttributes flashAttr) {
        System.out.println("m inside post");

       
        
        String view = "redirect:/";
        //System.out.println("customerController Add");
//        System.out.println( "hello" + result.getFieldValue("subscriptionRule.id"));
//        System.out.println( "hello" + result.getFieldValue("subscriptionRule"));
//        Long id= Long.valueOf((String)result.getFieldValue("subscriptionRule"));
        
//        result.findEditor((String) result.getFieldValue("subscriptionRule.startRange"),SubscriptionRule.class);
        
           System.out.println( "hello" + result.getFieldValue("subscriptionRule"));
           
           
//        for(SubscriptionRule sub:subscriptionRule)
//        {
//        if(id==sub.getId())
//        {
//            vendor.setSubscriptionRule(sub);
//        }
//        }
//        
//      session.removeAttribute("credential");
        if (!result.hasErrors()) {
            System.out.println("m ihere");
            
//            vendor.setSubscriptionRule((SubscriptionRule) result.getModel().values());

            vendorService.addVendor(vendor);
            flashAttr.addFlashAttribute("successfulSignup", "Venodr signed up succesfully. please  log in to proceed");

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
              
            }
            System.out.println("before");
            view = "addVendor";
        }
        return view;
    }

}
