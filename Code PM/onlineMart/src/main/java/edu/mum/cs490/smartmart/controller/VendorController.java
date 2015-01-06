/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;


import edu.mum.cs490.smartmart.domain.SubscriptionRule;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.ISubscriptionRuleService;
import edu.mum.cs490.smartmart.service.IVendorService;
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
 * @author Stella
 */
@Controller
public class VendorController {

    public VendorController() {
    }

    List<SubscriptionRule> subscriptionRule;
    @Autowired
    ISubscriptionRuleService subscriptionRuleService;
    
    @Autowired
    private IVendorService vendorService;

    public IVendorService getVendorService() {
        return vendorService;
    }

    public void setVendorService(IVendorService vendorService) {
        this.vendorService = vendorService;
    }

    public List<SubscriptionRule> getSubscriptionRule() {
        return subscriptionRule;
    
     @RequestMapping(value = "/viewPendingVendors", method = RequestMethod.GET)
    public String getPendingVendors(Model model, HttpSession session) {
        model.addAttribute("pendingVendors",vendorService.getAllPendingVendors());
         return "viewPendingVendors";
    }
    
     @RequestMapping(value = "/approveVendors/{id}", method = RequestMethod.POST)
    public String approveVendors(@PathVariable Long id, String Status, Model model, HttpSession session) {
         System.out.println("approveVendor controler!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
       Vendor vendor = vendorService.getVendorById(id);
        if (Status.equalsIgnoreCase("ACTIVE")) {
            vendor.setStatus(VendorStatus.ACTIVE);
        } else {
            vendor.setStatus(VendorStatus.REJECTED);
        }
        vendorService.update(vendor);
         System.out.println("vendor "+ vendor.getId());
         return "redirect:/viewPendingVendors";
    }
    
    @RequestMapping(value = "/VendorsForUnsubscribe", method = RequestMethod.GET)
    public String getVendorsForUnsubscribe(Model model, HttpSession session) {
        model.addAttribute("vendors",vendorService.getAllActiveVendor());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
         return "vendorUnsubscribe";
    }
    
    @RequestMapping(value = "/unsubscribeVendors/{id}", method = RequestMethod.POST)
    public String unsubscribeVendors(@PathVariable Long id, String Status, Model model, HttpSession session) {
         System.out.println("unsubscribeVendors controler!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
       Vendor vendor = vendorService.getVendorById(id);
       if (Status.equalsIgnoreCase("DEACTIVATE")) {
            vendor.setStatus(VendorStatus.DEACTIVATE);
        vendorService.update(vendor);
         System.out.println("vendor "+ vendor.getId());
             }
       return "redirect:/VendorsForUnsubscribe";
    }

    public void setSubscriptionRule(List<SubscriptionRule> subscriptionRule) {
        this.subscriptionRule = subscriptionRule;
    }

    @RequestMapping(value = "/viewPendingVendors", method = RequestMethod.GET)
    public String getPendingVendors(Model model, HttpSession session) {
        // if (session.getAttribute("pendingVendors") == null) {
//            List<Vendor> pendingVendors = new ArrayList();
//            pendingVendors=vendorService.getAllVendors();
        model.addAttribute("pendingVendors", vendorService.getAllVendors());
            //session.setAttribute("pendingVendors", vendorService.getAllVendors());
        //  }

        return "viewPendingVendors";
    }

    @RequestMapping(value = "/addVendor", method = RequestMethod.GET)
    public String addVendor(@ModelAttribute("vendor") Vendor vendor, Model model) {
        subscriptionRule = subscriptionRuleService.getAllSubscriptionRules();
        model.addAttribute("subscriptionRule", subscriptionRuleService.getAllSubscriptionRules());
        return "vendorRegisteration";
    }

    @RequestMapping(value = "/addVendor", method = RequestMethod.POST)
    public String add(@Valid Vendor vendor, BindingResult result, HttpSession session, RedirectAttributes flashAttr) {
        System.out.println("m inside post");

        String view = "redirect:/";
        if (!result.hasErrors()) {
            vendorService.addVendor(vendor);
            flashAttr.addFlashAttribute("successfulSignup", "Venodr signed up succesfully. please  log in to proceed");

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());

            }

            view = "addVendor";
        }
        return view;
    }

}
