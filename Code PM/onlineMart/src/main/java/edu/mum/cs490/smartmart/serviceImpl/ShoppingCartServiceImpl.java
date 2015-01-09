/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.dao.IShoppingCartItemDAO;
import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.ShoppingCartItem;
import edu.mum.cs490.smartmart.service.INotificationService;
import edu.mum.cs490.smartmart.service.IShoppingCartService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */
@Transactional(propagation = Propagation.REQUIRED)
public class ShoppingCartServiceImpl implements IShoppingCartService {

    private IShoppingCartItemDAO shoppingcartDAO;
    
   

    
    public IShoppingCartItemDAO getShoppingcartDAO() {
        return shoppingcartDAO;
    }

    public void setShoppingcartDAO(IShoppingCartItemDAO shoppingcartDAO) {
        this.shoppingcartDAO = shoppingcartDAO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public ShoppingCartItem getShoppingCart(Long id) {
        return shoppingcartDAO.findByPrimaryKey(id);

    }


    @Override
    public void clearCart(int id) {
   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }

    @Override
    public void addShoppingCartItem(Customer customer, ShoppingCartItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteShoppingCartItem(Customer customer, ShoppingCartItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<ShoppingCartItem> getCustomerShoppingCart(Customer customer) {

        //ShoppingCartItem cartItem = new ShoppingCartItem();
       // cartItem.setCustomer(customer);

        return shoppingcartDAO.getCustomerShoppingCart(customer);
   

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<ShoppingCartItem> findAll() {

        return shoppingcartDAO.findAll(0, 10);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteShoppingCartItem(ShoppingCartItem item) {
        shoppingcartDAO.delete(item);

    }

    @Override
    public void updateCart(ShoppingCartItem item) {

        shoppingcartDAO.save(item);
    }

    @Override
    public void addShoppingCart(ShoppingCartItem item) {
       shoppingcartDAO.save(item);
    
    }

    @Override
    public void clearCustomerShoppingCart(Customer customer) {
       shoppingcartDAO.clearCustomerShoppingCart(customer);
    
    }

    @Override
    public ShoppingCartItem getShoppingCartByProduct(Long id) {
        
        return shoppingcartDAO.getShoppingCartByProduct(id);
    }
}
