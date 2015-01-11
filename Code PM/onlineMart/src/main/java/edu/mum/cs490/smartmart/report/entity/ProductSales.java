/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.report.entity;

import java.util.Date;
import java.util.Objects;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author senai
 */
public class ProductSales {
    
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date startDate;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date endDate;
    
    private Long productId;
    private String productName;
    private Integer qtyInStock;
    private Integer qtySold;
    private Double totalPriceSold;
    private Double totalNetIncome;

    public ProductSales() {
    }

    public ProductSales(Long productId, String productName, Integer qtyInStock, Integer qtySold, Double totalPriceSold, Double totalNetIncome) {
        this.productId = productId;
        this.productName = productName;
        this.qtyInStock = qtyInStock;
        this.qtySold = qtySold;
        this.totalPriceSold = totalPriceSold;
        this.totalNetIncome = totalNetIncome;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(Integer qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public Integer getQtySold() {
        return qtySold;
    }

    public void setQtySold(Integer qtySold) {
        this.qtySold = qtySold;
    }

    public Double getTotalPriceSold() {
        return totalPriceSold;
    }

    public void setTotalPriceSold(Double totalPriceSold) {
        this.totalPriceSold = totalPriceSold;
    }

    public Double getTotalNetIncome() {
        return totalNetIncome;
    }

    public void setTotalNetIncome(Double totalNetIncome) {
        this.totalNetIncome = totalNetIncome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.productId);
        hash = 89 * hash + Objects.hashCode(this.productName);
        hash = 89 * hash + Objects.hashCode(this.qtyInStock);
        hash = 89 * hash + Objects.hashCode(this.qtySold);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductSales other = (ProductSales) obj;
        if (!Objects.equals(this.productId, other.productId)) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.qtyInStock, other.qtyInStock)) {
            return false;
        }
        if (!Objects.equals(this.qtySold, other.qtySold)) {
            return false;
        }
        return true;
    }
    
    
}
