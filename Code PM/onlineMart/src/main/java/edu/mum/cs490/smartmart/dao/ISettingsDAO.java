/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao;

import edu.mum.cs490.smartmart.domain.Settings;
import java.io.Serializable;

/**
 *
 * @author Fetiya
 */
public interface ISettingsDAO  extends IGenericDAO<Settings, Long>{
   public String findSettingsValueByName(String name);
}
