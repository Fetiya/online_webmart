/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.SubscriptionRule;
import java.util.List;

/**
 *
 * @author Komal
 */
public interface ISubscriptionRuleService {
     public List<SubscriptionRule> getAllSubscriptionRules();
}
