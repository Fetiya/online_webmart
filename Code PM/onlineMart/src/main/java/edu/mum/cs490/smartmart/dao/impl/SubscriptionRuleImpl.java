/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.ISubscriptionRule;
import edu.mum.cs490.smartmart.domain.SubscriptionRule;
import edu.mum.cs490.smartmart.domain.Users;

/**
 *
 * @author Stella
 */
public class SubscriptionRuleImpl extends GenericDAOImpl<Users, Long> implements ISubscriptionRule{

    public SubscriptionRuleImpl() {
        super(SubscriptionRule.class);
    }
    
}
