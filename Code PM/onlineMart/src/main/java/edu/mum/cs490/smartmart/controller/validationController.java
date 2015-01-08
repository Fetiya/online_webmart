/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author Stella
 */
@RestController
public class validationController {
     
      @RequestMapping(value = "/dispUser/{cardNumber}", method = RequestMethod.POST)
     public String dispUser(@PathVariable("cardNumber") String cardNumber) {
         System.out.println("dispUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
    RestTemplate restTemplate = new RestTemplate();
   String url="http://localhost:8080/PaymentGateWay/webresources/com.mypayment.paymentgateway.payment/findCardByNumber/{cardNumber}";
   Boolean resualt=restTemplate.getForObject(url, Boolean.class,cardNumber);
          System.out.println("dispUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +resualt);
         return "index";
     }
     
      @RequestMapping(value = "/cardValidation", method = RequestMethod.POST,headers = {"Accept: text/html,application/xhtml+xml,application/xml"}, produces="application/xml")
     public @ResponseBody String Cardvalidation(String cardNumber,String securityNumber,String totalAmount,Model model, HttpSession session) {
         System.out.println("values from cardvalidation controler"+ cardNumber+securityNumber+totalAmount);
         RestTemplate restTemplate = new RestTemplate();
         String url="http://localhost:8080/PaymentGateWay/webresources/com.mypayment.paymentgateway.payment/checkValidation/123/1234/1000";
         boolean result=restTemplate.getForObject(url, Boolean.class);
          System.out.println(result+"1111111111111111111111111111111111111");
          if(result){
              return "index";
          }
        return "index";
        
        
        
                }
    
}
