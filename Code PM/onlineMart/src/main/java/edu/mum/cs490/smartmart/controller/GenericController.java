/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dipika
 */
@Controller
public class GenericController {
    
    @RequestMapping(value="contactUs", method = RequestMethod.GET)
    public String mapContactUs() {
        return "contact-us";
    }
    
    @RequestMapping(value="/blogPage", method = RequestMethod.GET) 
    public String mapBlog() {
        return("redirect:/blog");
    }
    
    @RequestMapping(value="/blog") 
    public String blogPage() {
        return "blog";
    }
}
