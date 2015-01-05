/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.SubscriptionRuleDAO;
import edu.mum.cs490.smartmart.domain.SubscriptionRule;

/**
 *
 * @author Komal
 */
public class SubscriptionRuleDAOImpl extends GenericDAOImpl<SubscriptionRule, Long> implements SubscriptionRuleDAO {

    public SubscriptionRuleDAOImpl() {
        super(SubscriptionRule.class);
    }
    
}
