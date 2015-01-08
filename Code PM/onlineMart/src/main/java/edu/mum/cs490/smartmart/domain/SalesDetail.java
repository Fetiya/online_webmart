/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dipika
 */
@Entity
public class SalesDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private double  profitAmount;
    @NotNull
    private double profitToSmartmart;
    @NotNull
    private double profitToVendor;//should be changed to incomeToVendor
    @OneToOne
    private OrderItem orderItem;
    
    
    public SalesDetail() {
    }
    
    public Long getId() {
        return id;
    }

    public double getProfitAmount() {
        return profitAmount;
    }

    public void setProfitAmount(double profitAmount) {
        this.profitAmount = profitAmount;
    }

    public double getProfitToSmartmart() {
        return profitToSmartmart;
    }

    public void setProfitToSmartmart(double profitToSmartmart) {
        this.profitToSmartmart = profitToSmartmart;
    }

    public double getProfitToVendor() {
        return profitToVendor;
    }

    public void setProfitToVendor(double profitToVendor) {
        this.profitToVendor = profitToVendor;
    }

    public OrderItem getOrderitem() {
        return orderItem;
    }

    public void setOrderitem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesDetail)) {
            return false;
        }
        SalesDetail other = (SalesDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs490.webmart.domain.SalesDetail[ id=" + id + " ]";
    }
    
}
