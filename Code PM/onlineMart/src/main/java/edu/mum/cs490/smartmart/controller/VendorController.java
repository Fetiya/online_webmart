/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Address;
import edu.mum.cs490.smartmart.domain.Credential;
import edu.mum.cs490.smartmart.domain.Role;
import edu.mum.cs490.smartmart.domain.SubscriptionRule;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorAdmin;
import edu.mum.cs490.smartmart.service.ICustomerService;
import edu.mum.cs490.smartmart.service.IEncryptionService;
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

    
    Credential cred = new Credential();
    Address add= new Address();
    public VendorController() {
    }

    @Autowired
    ISubscriptionRuleService subscriptionRuleService;

    @Autowired
    private IVendorService vendorService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEncryptionService encryptionService;

    public IVendorService getVendorService() {
        return vendorService;
    }

    public void setVendorService(IVendorService vendorService) {
        this.vendorService = vendorService;
    }

    public ISubscriptionRuleService getSubscriptionRuleService() {
        return subscriptionRuleService;
    }

    public void setSubscriptionRuleService(ISubscriptionRuleService subscriptionRuleService) {
        this.subscriptionRuleService = subscriptionRuleService;
    }

    public IEncryptionService getEncryptionService() {
        return encryptionService;
    }

    public void setEncryptionService(IEncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
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
        model.addAttribute("vendor",vendor);
//        subscriptionRule = subscriptionRuleService.getAllSubscriptionRules();
//        model.addAttribute("subscriptionRule", subscriptionRuleService.getAllSubscriptionRules());
        return "vendorRegisteration";
    }

    @RequestMapping(value = "/addVendor", method = RequestMethod.POST)
    public String add(@Valid Vendor vendor, BindingResult result, HttpSession session, RedirectAttributes flashAttr) {
        String view = "redirect:/companyAddressInformation";
        if (!result.hasErrors()) {

//            Credential credential = (Credential) session.getAttribute("credential");
//            Address address = (Address) session.getAttribute("adminAddress");
            
            //Commenting
//            Address companyAddress = (Address) session.getAttribute("comapnyAddress");
//            SubscriptionRule subscriptionRule = (SubscriptionRule) session.getAttribute("subscriptionRule");
//            VendorAdmin vendorAdmin = (VendorAdmin) session.getAttribute("vendorAdmin");
//            vendor.setAddress(companyAddress);
//            vendor.setSubscriptionRule(subscriptionRule);
            
            
           session.setAttribute("vendor", vendor);
            
//            VendorAdmin vendoradmin = new VendorAdmin();
//            vendorAdmin.setCredential(credential);
//            vendorAdmin.setAddress(address);
//            vendor.setVendorAdmin(vendorAdmin);

//            vendor.getVendorAdmin().setCredential(credential);
//            vendor.getVendorAdmin().setAddress(address);

//            vendorService.addVendor(vendor);
//            session.removeAttribute("credential");
//            session.removeAttribute("address");
//            session.removeAttribute("subscriptionRule");
//            session.removeAttribute("companyAddress");
//            session.removeAttribute("vendorAdmin");
            
            flashAttr.addFlashAttribute("successfulSignup", "Venodr signed up succesfully. please  log in to proceed");

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());

            }

            view = "vendorRegisteration";
        }
        return view;
    }

    // Personal Address
    @RequestMapping(value = "/addAdminAddress", method = RequestMethod.GET)
    public String addAdminAddress(@ModelAttribute("adminAddress") Address adminAddress, Model model) {
        model.addAttribute("adminAddress", adminAddress);
        return "addAdminAddressRegisteration";
    }

    @RequestMapping(value = "/addAdminAddress", method = RequestMethod.POST)
    public String addAdAddress(@Valid Address adminAddress, BindingResult result, HttpSession session) {

        String view = "redirect:/addVendorAdmin";

        if (!result.hasErrors()) {
            add = adminAddress;
            session.setAttribute("adminAddress", adminAddress);

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
            }
            view = "addAdminAddressRegisteration";
        }
        return view;
    }

    //Company Address
    @RequestMapping(value = "/companyAddressInformation", method = RequestMethod.GET)
    public String addCompanyAddress(@ModelAttribute("companyAddress") Address comapnyAddress,Model model) {
        model.addAttribute("companyAddress",comapnyAddress);
        return "companyAddressInformation";
    }

    @RequestMapping(value = "/companyAddressInformation", method = RequestMethod.POST)
    public String addCompany(@Valid Address comapnyAddress, BindingResult result, HttpSession session) {

        String view = "redirect:/selectSubscriptionRule";

        if (!result.hasErrors()) {

            session.setAttribute("companyAddress", comapnyAddress);

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
            }
            view = "companyAddressInformation";
        }
        return view;
    }

    // Add Credetial Information
    @RequestMapping(value = "/addAdminCredential", method = RequestMethod.GET)
    public String addCredential(@ModelAttribute("credential") Credential credential, Model model) {
        model.addAttribute("credential", credential);
        return "addAdminCredential";
    }

    @RequestMapping(value = "/addAdminCredential", method = RequestMethod.POST)
    public String addCredential(@Valid Credential credential, BindingResult result, HttpSession session) {
        String view = "redirect:/addAdminAddress";
        boolean used = customerService.checkUserName(credential.getUsername());
        if (used) {
            FieldError f = new FieldError("credential", "userName", credential.getUsername(), false, null, null, "Username : " + credential.getUsername() + " already in use");
            result.addError(f);
        }
        if (!result.hasErrors()) {
            credential.setRole(Role.VENDORADMIN);
            credential.setPassword(encryptionService.getEncryptedPassword(credential.getPassword()));
            credential.setActive(false);
            cred = credential;
            
            session.setAttribute("credential", credential);

        } else {
            view = "addAdminCredential";
        }
        return view;
    }

    //
    //Subscription Rule
    @RequestMapping(value = "/selectSubscriptionRule", method = RequestMethod.GET)
    public String showSubscriptionRule(@ModelAttribute("subscriptionRule") SubscriptionRule subscriptionRule, Model model) {
        List<SubscriptionRule> subscriptionRuleList = subscriptionRuleService.getAllSubscriptionRules();
        model.addAttribute("rule", subscriptionRuleList);
        model.addAttribute("subscriptionRule", subscriptionRule);
        return "selectSubscriptionRule";
    }

    @RequestMapping(value = "/selectSubscriptionRule", method = RequestMethod.POST)
    public String addSubscriptionRule(@Valid SubscriptionRule subscriptionRule, BindingResult result, HttpSession session) {

        String view = "redirect:/addAdminCredential";

        if (!result.hasErrors()) {

            session.setAttribute("subscriptionRule", subscriptionRule);

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
            }
            view = "selectSubscriptionRule";
        }
        return view;
    }

//     Personal Information
    @RequestMapping(value = "/addVendorAdmin", method = RequestMethod.GET)
    public String addCustomer(@ModelAttribute("vendorAdmin") VendorAdmin vendorAdmin, Model model) {
        model.addAttribute("vendorAdmin", vendorAdmin);
        return "adminRegisteration";

    }
    
       @RequestMapping(value = "/addVendorAdmin", method = RequestMethod.POST)
    public String add(@Valid VendorAdmin vendorAdmin, BindingResult result, HttpSession session, Model model) {

        String view = "redirect:/";

        if (!result.hasErrors()) { 
            Credential credential = (Credential) session.getAttribute("credential");
            Address address = (Address) session.getAttribute("adminAddress");
            Address companyAddress = (Address) session.getAttribute("companyAddress");
            Vendor vendor = (Vendor) session.getAttribute("vendor");
            SubscriptionRule subscriptionRule = (SubscriptionRule) session.getAttribute("subscriptionRule");
            vendorAdmin.setVendor(vendor);
            vendorAdmin.setCredential(credential);
            vendorAdmin.setAddress(address);
            vendor.setVendorAdmin(vendorAdmin);
            vendor.setAddress(companyAddress);
            vendor.setSubscriptionRule(subscriptionRule);
            session.setAttribute("vedorAdmin", vendorAdmin);
            vendorService.addVendor(vendor);
            session.removeAttribute("credential");
            session.removeAttribute("adminAddress");
            session.removeAttribute("companyAddress");
            session.removeAttribute("vendor");
            session.removeAttribute("subscriptionRule");

        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
            }
            view = "adminRegisteration";
        }
        return view;
    }
}
