/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorStatus;
import edu.mum.cs490.smartmart.service.VendorService;
import java.util.ArrayList;
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
 * @author Stella
 */
@Controller
public class VendorController {

    public VendorController() {
    }
    
    @Autowired
    private VendorService vendorService;

    public VendorService getVendorService() {
        return vendorService;
    }

    public void setVendorService(VendorService vendorService) {
        this.vendorService = vendorService;
    }
    
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
            vendor.setStatus(VendorStatus.DEACTIVATE);
        vendorService.update(vendor);
         System.out.println("vendor "+ vendor.getId());
         return "redirect:/VendorsForUnsubscribe";
    }

 }
