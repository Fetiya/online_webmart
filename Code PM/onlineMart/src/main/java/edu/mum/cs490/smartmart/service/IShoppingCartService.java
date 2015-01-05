package edu.mum.cs490.smartmart.service;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.ShoppingCartItem;
import java.util.List;

/**
 *
 * @author Senai
 */
public interface IShoppingCartService {

    public List<ShoppingCartItem> getShoppingCart(int id);

    public List<ShoppingCartItem> getCart(Customer customer);

    public void clearCart(int id);

    public void addShoppingCartItem(Customer customer, ShoppingCartItem item);

    public void deleteShoppingCartItem(Customer customer, ShoppingCartItem item);

}
