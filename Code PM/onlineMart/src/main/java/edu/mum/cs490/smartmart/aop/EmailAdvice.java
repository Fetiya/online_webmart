/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.aop;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Order;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.INotificationService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author Komal
 */
@Aspect
public class EmailAdvice {

    private INotificationService notificationService;

    public void setNotificationService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Send an email every time the customer signed up
     *
     * @param jp
     */
//    @AfterReturning(pointcut = "execution(* com.oak_yoga_studio.service.impl.CustomerServiceImpl.addCustomer(..))")
    @AfterReturning(pointcut = "execution(* edu.mum.cs490.smartmart.serviceImpl.CustomerServiceImpl.addCustomer(..))")
    public void customerSignupEmailNotification(JoinPoint jp) {
        Customer c = (Customer) jp.getArgs()[0];

        System.out.println("Eamil Notification--------------------------/////-----");
        String text = "Welcome to Smart Mart.You are successfully registered.";

        notificationService.notifyCustomerSignUp(c, text);
    }

    @AfterReturning(pointcut = "execution(* edu.mum.cs490.smartmart.serviceImpl.VendorServiceImpl.addVendor(..))")
    public void vendorSignupEmailNotification(JoinPoint jp) {
        Vendor v = (Vendor) jp.getArgs()[0];

        System.out.println("Eamil Notification--------------------------/////-----");
        String text = "Welcome to Smart Mart.Your request is pending to approve.\n We will get back you to soon.";

        notificationService.notifyVendorSignUp(v, text);
    }
    
    
    //need to add vendor unsubscription and aproval method 
     @AfterReturning(pointcut = "execution(* edu.mum.cs490.smartmart.controller.VendorController.unsubscribeVendors(..))")
    public void notifayVendorStatus(JoinPoint jp) {
        Vendor v = (Vendor) jp.getArgs()[0];

        System.out.println("Eamil Notification--------------------------/////-----");
        String text = "Welcome to Smart Mart.Your request is approve.\n You can loggin to use our service.";

        notificationService.notifyVendorSignUp(v, text);
    }
    
      @AfterReturning(pointcut = "execution(* edu.mum.cs490.smartmart.serviceImpl.CustomerServiceImpl.notifyCustomerCheckout(..))")
    public void checkoutEmailNotification(JoinPoint jp) {
        Order order = (Order) jp.getArgs()[1];
 Customer customer=(Customer) jp.getArgs()[0];
         String text = "we received your SmartMart's order! \n\n\n Thanks for your SmartMart's order—check out the details below!"
                + "We'll email additional info, like shipping & tracking details, as your order is processed. \n\n Order # " + order.getId() 
                + "\nOrder Date" + order.getOrderDate();

        notificationService.notifyCustomerCheckout(customer, text);
    }
}
