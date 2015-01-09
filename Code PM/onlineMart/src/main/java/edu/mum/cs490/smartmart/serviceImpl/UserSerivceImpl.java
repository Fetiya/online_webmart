/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.IUserDAO;
import edu.mum.cs490.smartmart.dao.impl.UserDAOImpl;
import edu.mum.cs490.smartmart.domain.Credential;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.service.IUserService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */
//@Service("userService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserSerivceImpl implements IUserService {

    IUserDAO userDAO;

    public IUserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean createUser(Users user) {
        userDAO.save(user);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<Users> getAllUsers() {

        List<Users> users = userDAO.findAll(0, 10);
        return users;
    }

    @Override
    public Users getUserById(Long id) {
        return userDAO.findByPrimaryKey(id);
    }

    @Override
    public Users getUserByUsername(String userName) {
        Credential cred = new Credential();
        cred.setUsername(userName);
        Users user = new Users();
        user.setCredential(cred);
        List<Users> matchingusers = userDAO.findByExample(user, new String[]{});
        if (matchingusers.size() == 1) {
            return matchingusers.get(0);
        } else {
            return null;
        }
    }

    @Override
    public void updateUser(Users user) {
        userDAO.save(user);
    }
    
    
    
   

}
