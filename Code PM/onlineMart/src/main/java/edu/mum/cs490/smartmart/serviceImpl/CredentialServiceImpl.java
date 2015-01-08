/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.ICredentialDAO;
import edu.mum.cs490.smartmart.domain.Credential;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.service.ICredentialService;
import java.util.List;

/**
 *
 * @author Komal
 */
public class CredentialServiceImpl implements ICredentialService{ 

    ICredentialDAO credentialDAO;

    public ICredentialDAO getCredentialDAO() {
        return credentialDAO;
    }

    public void setCredentialDAO(ICredentialDAO credentialDAO) {
        this.credentialDAO = credentialDAO;
    }
    
    
    
    @Override
    public Users getCredentialByUserName(String userName){
        List<Credential>  credential = credentialDAO.findAll(0, 10);
        Credential cr = null;
        for (Credential crd: credential)
        {
            if(crd.getUsername().equals(userName))
              cr= crd;
        }

        Users user = null;
        if (cr != null) {
            user = cr.getUser();

        }
        return user;
    }
    
}
