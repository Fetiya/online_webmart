/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author dipika
 */
@Entity
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank (message = "{NotBlank.Vendor.companyName.validation}")
    private String companyName;
    @OneToOne(cascade = CascadeType.ALL)
    private @Valid Address address;
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    private List<Product> productlist;
    @OneToOne
    private SubscriptionRule subscriptionRule;
    @NotBlank(message = "{NotBlank.Vendor.accountNum.validation}")
    private String accountNum;
    @Enumerated(EnumType.STRING)
    private VendorStatus status;
    // commenting bcs of path error
//    @OneToMany (mappedBy = "vendor", cascade = CascadeType.ALL)
//    private List<VendorAdmin> admins;
    @OneToOne(mappedBy = "vendor", cascade = CascadeType.ALL)
    private VendorAdmin vendorAdmin; //= new VendorAdmin();

    public Vendor() {
//        vendorAdmin = new VendorAdmin();
//        admins.add(vendorAdmin);
    }

//    public List<VendorAdmin> getAdmins() {
//        return admins;
//    }
//
//    public void setAdmins(List<VendorAdmin> admins) {
//        this.admins = admins;
//    }
    public VendorStatus getStatus() {
        return status;
    }

    public void setStatus(VendorStatus status) {
        this.status = status;
    }

    public VendorAdmin getVendorAdmin() {
        return vendorAdmin;
    }

    public void setVendorAdmin(VendorAdmin vendorAdmin) {
        this.vendorAdmin = vendorAdmin;
    }

    public List<Product> getProductlist() {
        return productlist;
    }

    public void setProductlist(List<Product> productlist) {
        this.productlist = productlist;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public SubscriptionRule getSubscriptionRule() {
        return subscriptionRule;
    }

    public void setSubscriptionRule(SubscriptionRule subscriptionRule) {
        this.subscriptionRule = subscriptionRule;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
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
        if (!(object instanceof Vendor)) {
            return false;
        }
        Vendor other = (Vendor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs490.webmart.domain.Vendors[ id=" + id + " ]";
    }

}
