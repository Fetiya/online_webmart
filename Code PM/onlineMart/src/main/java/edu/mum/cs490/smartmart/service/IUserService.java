/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.Users;
import java.util.List;

/**
 *
 * @author Fetiya
 */
public interface IUserService {

    public Users getUserById(Long id);

    public Users getUserByUsername(String userName);

    public List<Users> getAllUsers();

    public void updateUser(Users user);
}
