/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.Order;
import edu.mum.cs490.smartmart.domain.OrderItem;
import java.util.List;

/**
 *
 * @author Somayeh
 */
public interface IOrderService {    
      
    public void addOrder(Order order);
    
    public Order getOrderById(int id);
    
    public void updateOrder(Order order);
    
    public List<Order> getAllOrders();
    
    public void addOrderItem(OrderItem ol);
    
    public OrderItem getOrderItemById(int id);
    
    public void updateOrderItem(OrderItem orderItem);
    
    public List<OrderItem> getAllOrderItems();
    
    public List<OrderItem> getAllOrderItemsOfOrder(int orderId);
    
  }
