/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.ISettingsDAO;
import edu.mum.cs490.smartmart.domain.Settings;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Fetiya
 */
@Transactional(propagation=Propagation.MANDATORY)
public class SettingsDAOImpl extends GenericDAOImpl<Settings, Long> implements ISettingsDAO{

    public SettingsDAOImpl() {
        super(Settings.class);
    }

    @Override
    public String findSettingsValueByName(String name) {
       
       Query query =getSf().getCurrentSession().createQuery("select s.value from Settings s where s.name=:name ");
       
       query.setParameter("name", name);
       
       String result = (String) query.uniqueResult();
       
       return result;
       
    }
    
}
