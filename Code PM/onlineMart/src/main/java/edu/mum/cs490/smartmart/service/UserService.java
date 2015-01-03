/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.dao.UserDAO;
import edu.mum.cs490.smartmart.domain.Users;
//import edu.mum.cs490.smartmart.domain.User;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */
public interface UserService {
        
   public List<Users> getAllUsers();
}
