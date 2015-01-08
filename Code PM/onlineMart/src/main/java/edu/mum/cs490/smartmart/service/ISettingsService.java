/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.Settings;
import java.util.List;

/**
 *
 * @author Fetiya
 */
public interface ISettingsService {
   
    public String getSettingsValueByName(String name);
    public void addSetting(Settings setting);
    public void  updateSettings(Settings setting);
    public List<Settings> getAllSettings();
    public Settings getSetting(long id);
    public void deleteSetting(Settings setting);
}
