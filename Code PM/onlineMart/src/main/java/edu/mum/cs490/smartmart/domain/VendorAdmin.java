/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author dipika
 */
@Entity
public class VendorAdmin extends Users  {

    @OneToOne
    private Vendor vendor;

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

  
}
