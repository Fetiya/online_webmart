/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.ISalesDetailDAO;
import edu.mum.cs490.smartmart.domain.SalesDetail;
import edu.mum.cs490.smartmart.service.ISalesDetailService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */
@Transactional(propagation = Propagation.REQUIRED)
public class SalesDetailServiceImpl implements ISalesDetailService {
    
    ISalesDetailDAO salesDetailDAO;

    public ISalesDetailDAO getSalesDetailDAO() {
        return salesDetailDAO;
    }

    public void setSalesDetailDAO(ISalesDetailDAO salesDetailDAO) {
        this.salesDetailDAO = salesDetailDAO;
    }

    @Override
    public void addSalesDetail(SalesDetail salesDetail) {
       
        salesDetailDAO.save(salesDetail);
    
    }
    
    
}
