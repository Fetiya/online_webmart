/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.VendorService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
       // if (session.getAttribute("pendingVendors") == null) {
//            List<Vendor> pendingVendors = new ArrayList();
//            pendingVendors=vendorService.getAllVendors();
             model.addAttribute("pendingVendors",vendorService.getAllVendors());
            //session.setAttribute("pendingVendors", vendorService.getAllVendors());
      //  }

        return "viewPendingVendors";
    }
 }
