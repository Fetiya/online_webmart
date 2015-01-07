/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.ISalesDetailDAO;
import edu.mum.cs490.smartmart.domain.SalesDetail;
import java.io.Serializable;

/**
 *
 * @author Fetiya
 */
public class SalesDetailDAOImpl extends GenericDAOImpl<SalesDetail, Long> implements ISalesDetailDAO{

    public SalesDetailDAOImpl() {
        super(SalesDetail.class);
    }
    
}
