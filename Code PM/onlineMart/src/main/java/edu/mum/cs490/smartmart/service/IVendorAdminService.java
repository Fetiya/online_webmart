/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.VendorAdmin;
import java.util.List;

/**
 *
 * @author Senai
 */
public interface IVendorAdminService {

    public VendorAdmin getVendorAdminById(int Id);

    public void addVendorAdmin(VendorAdmin vendorAdmin);

    public List<VendorAdmin> getListOfActiveVendorAdmin();

    public List<VendorAdmin> getListOfVendorAdmin();

    public void updateVendorAdmin(int id, VendorAdmin VendorAdmin);

    public void enableOrdisableVendorAdmin(VendorAdmin VendorAdmin);

}
