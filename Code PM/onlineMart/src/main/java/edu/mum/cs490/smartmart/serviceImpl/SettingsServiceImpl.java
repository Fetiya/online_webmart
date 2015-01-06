/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.ISettingsDAO;
import edu.mum.cs490.smartmart.service.ISettingsService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */
@Transactional(propagation = Propagation.REQUIRED)
public class SettingsServiceImpl implements ISettingsService {

    ISettingsDAO settingsDAO;

    public ISettingsDAO getSettingsDAO() {
        return settingsDAO;
    }

    public void setSettingsDAO(ISettingsDAO settingsDAO) {
        this.settingsDAO = settingsDAO;
    }

    @Override
    public String getSettingsValueByName(String name) {

        return settingsDAO.findSettingsValueByName( name);
    }
    
}
