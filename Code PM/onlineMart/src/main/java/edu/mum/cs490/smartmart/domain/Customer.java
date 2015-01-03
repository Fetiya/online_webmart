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
public class Customer extends Users implements Serializable {
    private static final long serialVersionUID = 1L;

    @OneToMany(cascade = CascadeType.ALL )
    private List<ShoppingCartItem> shoppingCart;
    @OneToMany(mappedBy = "customer")
    private List<Order> order;


    public Customer() {
    }

    public List<ShoppingCartItem> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<ShoppingCartItem> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

   

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    
}
