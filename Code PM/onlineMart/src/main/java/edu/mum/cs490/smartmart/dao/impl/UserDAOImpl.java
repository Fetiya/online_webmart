/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.IUserDAO;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.Users;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */


//@Repository("userDAO")
@Transactional(propagation=Propagation.MANDATORY)
public class UserDAOImpl extends GenericDAOImpl<Users, Long> implements IUserDAO {    
    
   public UserDAOImpl() {
     
    super(Users.class);
 }

    @Override
    public List<Users> findUsers(String userName) {
        
          List<Users> users;
        Query query = getSf().getCurrentSession().createQuery("select u from Users u where u.credential.username=:userName");
        
         query.setParameter("userName", userName);
       // query.setParameter("c", c);
        users = query.list();
        return users;
    }


}
