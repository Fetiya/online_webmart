/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.IOrderDAO;
import edu.mum.cs490.smartmart.domain.Order;
import edu.mum.cs490.smartmart.domain.OrderItem;
import edu.mum.cs490.smartmart.service.IOrderService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */

   @Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements IOrderService{

    
    IOrderDAO orderDAO;

    public IOrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(IOrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
    
    
    @Override
    public void addOrder(Order order) {
       
        orderDAO.save(order);
    
    }

    @Override
    public Order getOrderById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getAllOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOrderItem(OrderItem ol) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderItem getOrderItemById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateOrderItem(OrderItem orderItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderItem> getAllOrderItemsOfOrder(int orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
