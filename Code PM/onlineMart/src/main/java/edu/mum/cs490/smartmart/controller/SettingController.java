/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Settings;
import edu.mum.cs490.smartmart.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Kabiraj
 */
public class SettingController {
    
    @Autowired
    private ISettingsService settingService;
    
    @RequestMapping(value = "/addSetting", method = RequestMethod.POST)
    public String addProduct(Settings setting) {

        String view = "redirect:/settings";
        settingService.addSetting(setting);
        return view;
    }
    
    @RequestMapping(value = "/settingEdit/{id}", method = RequestMethod.GET)
    public String getProduct(Model model, @PathVariable long id) {
               return "editSetting";
    }
    
    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String getAll(Model model) {

        model.addAttribute("settings", settingService.getAllSettings());
        return "viewSetting";
    }
    
    @RequestMapping(value = "/addSetting", method = RequestMethod.GET)
    public String insertSetting(@ModelAttribute("settings") Settings settings) {      
        return "addSetting";
    }
    
    @RequestMapping(value = "/settingDelete/{id}", method = RequestMethod.GET)
    public String productDelete(Model model, @PathVariable long id) {
       
        Settings setting=settingService.getSetting(id);
        settingService.deleteSetting(setting);
        return "redirect:/products";
    }
    
    @RequestMapping(value = "/editSetting", method = RequestMethod.POST)
    public String updateProduct(Settings setting) {

        try {
          
            settingService.updateSettings(setting);
           
           

        } catch (Exception ex) {
            ex.printStackTrace();
        }
              
        return "redirect:/settings";

    }
    
}
