/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.webmart.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author dipika
 */
@Entity
public class Customer extends User implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(mappedBy ="customer", cascade = CascadeType.ALL )
    private ShoppingCartItem shoppingCart;
    @OneToMany(mappedBy = "customer")
    private List<Order> order;
    public Long getId() {
        return id;
    }

    public Customer() {
    }

    public ShoppingCartItem getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartItem shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs490.webmart.domain.Customer[ id=" + id + " ]";
    }
    
}
