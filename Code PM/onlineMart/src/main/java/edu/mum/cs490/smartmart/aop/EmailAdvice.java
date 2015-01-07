/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.aop;

import edu.mum.cs490.smartmart.domain.Customer;
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
}
