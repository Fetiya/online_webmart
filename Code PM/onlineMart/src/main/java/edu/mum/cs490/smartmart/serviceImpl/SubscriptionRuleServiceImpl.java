/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.SubscriptionRuleDAO;
import edu.mum.cs490.smartmart.domain.SubscriptionRule;
import edu.mum.cs490.smartmart.service.SubscriptionRuleService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Komal
 */
public class SubscriptionRuleServiceImpl implements SubscriptionRuleService {

    SubscriptionRuleDAO subscriptionRuleDAO;

    public SubscriptionRuleDAO getSubscriptionRuleDAO() {
        return subscriptionRuleDAO;
    }

    public void setSubscriptionRuleDAO(SubscriptionRuleDAO subscriptionRuleDAO) {
        this.subscriptionRuleDAO = subscriptionRuleDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<SubscriptionRule> getAllSubscriptionRules() {

        List<SubscriptionRule> subscriptionRule = subscriptionRuleDAO.findAll(0, 10);
        return subscriptionRule;
    }
}
