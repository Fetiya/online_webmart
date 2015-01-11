/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;


import java.util.Date;
import java.util.Map;

/**
 *
 * @author senai
 */
public interface IReportService {
    public abstract Map<String, Object> getVendorSalesReportByProduct(long vendorId, Date startDate,Date endDate);
}
