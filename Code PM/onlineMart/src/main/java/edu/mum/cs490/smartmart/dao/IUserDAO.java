/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao;

import edu.mum.cs490.smartmart.domain.Users;import java.util.List;
;


/**
 *
 * @author Fetiya
 */


public interface IUserDAO  extends IGenericDAO<Users, Long>{//   // extends HibernateDAO<User, Long> { //

    public List<Users> findUsers(String userName);
   
}
