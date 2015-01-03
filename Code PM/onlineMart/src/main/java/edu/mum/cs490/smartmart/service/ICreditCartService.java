package edu.mum.cs490.smartmart.service;

import org.hibernate.validator.constraints.CreditCardNumber;

/**
 *
 * @author Somayeh
 */
public interface ICreditCartService {
    
    public boolean checkValidityOfCreditCard(CreditCardNumber cnum, int verificationCode) ;
 
    
}
