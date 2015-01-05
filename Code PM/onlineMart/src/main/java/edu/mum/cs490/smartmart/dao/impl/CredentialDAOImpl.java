/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.ICredentialDAO;
import edu.mum.cs490.smartmart.domain.Credential;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Senai
 */

@Transactional(propagation=Propagation.MANDATORY)
public class CredentialDAOImpl extends GenericDAOImpl<Credential, Long> implements ICredentialDAO {

    public CredentialDAOImpl() {
        super(Credential.class);
    }

}

