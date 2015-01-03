/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.validators;


import edu.mum.cs490.smartmart.service.ICustomerService;
import edu.mum.cs490.smartmart.validators.annotations.UniqueUserName;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Senai
 * 
 * In-order to register in to the system you need to have a unique username
 * Its just business rule...
 * 
 */
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    @Autowired
    private  ICustomerService customerService;
    @Override
    public void initialize(UniqueUserName constraintAnnotation) {
    }

    public UniqueUserNameValidator() {
//        Thread.dumpStack();
    }
    

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("Unique:"+ value+":"+ customerService);
      
        boolean result= !customerService.checkUserName(value);
        System.out.println("result: " + result);
        return result;
    }

}
