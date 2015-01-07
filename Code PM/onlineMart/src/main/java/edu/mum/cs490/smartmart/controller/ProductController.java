/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ShoppingCartItem;
import edu.mum.cs490.smartmart.service.ICustomerService;

import edu.mum.cs490.smartmart.domain.CategoryPropertyEditor;
import edu.mum.cs490.smartmart.domain.Order;
import edu.mum.cs490.smartmart.domain.OrderItem;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.SalesDetail;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorPropertyEditor;
import edu.mum.cs490.smartmart.service.IOrderService;
import edu.mum.cs490.smartmart.service.IProductCategoryService;
import edu.mum.cs490.smartmart.service.IProductService;
import edu.mum.cs490.smartmart.service.IVendorService;
import java.beans.PropertyEditor;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.mum.cs490.smartmart.service.IProductService;
import edu.mum.cs490.smartmart.service.ISalesDetailService;
import edu.mum.cs490.smartmart.service.ISettingsService;
import edu.mum.cs490.smartmart.service.IShoppingCartService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Kabiraj
 */
@Controller
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductCategoryService productCategoryService;

    @Autowired
    private IVendorService vendorService;

    @Autowired
    public ICustomerService customerService;

    @Autowired
    IShoppingCartService shoppingCartService;

    @Autowired
    IOrderService orderService;
    
    @Autowired
    ISalesDetailService salesService;
    
    @Autowired
    ISettingsService settingsService;

    public ISettingsService getSettingsService() {
        return settingsService;
    }

    public void setSettingsService(ISettingsService settingsService) {
        this.settingsService = settingsService;
    }
    

    
    public ISalesDetailService getSalesService() {
        return salesService;
    }

    
    public void setSalesService(ISalesDetailService salesService) {
        this.salesService = salesService;
    }

    

    
    public IProductService getProductService() {
        return productService;
    }

    public ICustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(ICustomerService customerService) {
        this.customerService = customerService;
    }

    public IShoppingCartService getShoppingCartService() {
        return shoppingCartService;
    }

    public void setShoppingCartService(IShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    public IProductCategoryService getProductCategoryService() {
        return productCategoryService;
    }

    public void setProductCategoryService(IProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    public IVendorService getVendorService() {
        return vendorService;
    }

    public void setVendorService(IVendorService vendorService) {
        this.vendorService = vendorService;
    }

    public IOrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(Product product, @RequestParam("file") MultipartFile file) {

        String view = "redirect:/products";
        try {
            product.setImage(file.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("product iname is" + product.getName());
        productService.addProduct(product);
        return view;
    }

    @RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
    public String insertProduct(@ModelAttribute("product") Product product, Model model) {

        model.addAttribute("categories", productService.getListOfCategory());
        model.addAttribute("vendors", productService.getListOfVendor());
        return "insertProduct";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getAll(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        return "viewProducts";
    }

    @RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
    public String getAllProducts(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        return "viewProducts";
    }

    @RequestMapping(value = "/productImage/{id}", method = RequestMethod.GET)
    public void getProductImage(Model model, @PathVariable int id, HttpServletResponse response) {
        try {
            Product p = productService.getProduct(id);
            if (p != null) {
                OutputStream out = response.getOutputStream();
                out.write(p.getImage());

                response.flushBuffer();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)

    public String initHome(Model model) {

        model.addAttribute("products", productService.getAllProducts());
        
        return "index";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(ProductCategory.class, new CategoryPropertyEditor(productCategoryService));
        binder.registerCustomEditor(Vendor.class, new VendorPropertyEditor(vendorService));
    }

    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable int id, Model model, final RedirectAttributes re, HttpSession session) {

        //Customer customer = (Customer) session.getAttribute("loggedUser");
        Customer customer = customerService.getCustomerById(Long.valueOf(String.valueOf(1)));
        int quantity = 1;
        Product product = productService.getProduct(Long.valueOf(String.valueOf(id)));
        ShoppingCartItem cartItem = new ShoppingCartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setCustomer(customer);
        boolean flag = true;

        List<ShoppingCartItem> currentCartItems = shoppingCartService.getCustomerShoppingCart(customer);
        for (ShoppingCartItem item : currentCartItems) {

            if (item.getProduct().getId() == product.getId()) {
                //If the items are of the same product just update the quantity
                // ShoppingCartItem item = shoppingCartItemService.getCartItem(items.getId());
                item.setQuantity(item.getQuantity() + quantity);
                //update in the DB
                shoppingCartService.updateCart(item);
                flag = false;
                break;
            }
        }
        if (flag) {
            //if the items are of different product
            // customer.getShoppingCart().addShoppingCartItem(cartItem);
            customer.getShoppingCart().add(cartItem);
            //persist to DB

            shoppingCartService.addShoppingCart(cartItem);

        }

        String message = product.getName() + " has been added to shopping cart!";
        re.addFlashAttribute("message", message);
        return "redirect:/cart";

    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCustomerCart(Model model) {
        // System.out.println("Controller"+id);

        Customer customer = new Customer();
        Long id = Long.valueOf(String.valueOf(1));

        customer = customerService.getCustomerById(id);

        List<ShoppingCartItem> cartItems = shoppingCartService.findAll();
        double total = 0;
        for (ShoppingCartItem i : cartItems) {
            total += i.getProduct().getPrice() * i.getQuantity();
        }
        model.addAttribute("cartItems", cartItems);

        model.addAttribute("totalPrice", total);

        return "cart";
    }
    
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
     public String checkout(Model model, final RedirectAttributes re, HttpSession session) {
        return "checkout";
    }
     
     
//    @RequestMapping(value = "/validation", method = RequestMethod.POST)
//     public String validation(@Valid Customer customer, BindingResult result, RedirectAttributes flashAttr) {
//        
//        if (!result.hasErrors()) {
//            customerService.addCustomer(customer);
//            flashAttr.addFlashAttribute("successfulSignup", "Venodr signed up succesfully. please  log in to proceed");
//
//        } else {
//            for (FieldError err : result.getFieldErrors()) {
//                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
//            }
//            return "redirect:/checkout";
//        }
//        return "redirect:/cardValidation";
//        }

     
     @RequestMapping(value = "/cardValidation", method = RequestMethod.POST)
     public String Cardvalidation(String cardNumber,String securityNumber,String totalAmount,Model model, HttpSession session) {
         System.out.println("values from cardvalidation controler"+ cardNumber+securityNumber+totalAmount);
         RestTemplate restTemplate = new RestTemplate();
         String url="http://localhost:8080/PaymentGateWay/webresources/com.mypayment.paymentgateway.payment/checkValidation/123/1234/1000";
         boolean resualt=restTemplate.getForObject(url, Boolean.class);
          System.out.println(resualt+"1111111111111111111111111111111111111");
          if(resualt){
              return "index";
          }
        return "index";
        
                }
     
      @RequestMapping(value = "/dispUser/{cardNumber}", method = RequestMethod.POST)
     public String dispUser(@PathVariable("cardNumber") String cardNumber) {
         System.out.println("dispUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
    RestTemplate restTemplate = new RestTemplate();
   String url="http://localhost:8080/PaymentGateWay/webresources/com.mypayment.paymentgateway.payment/findCardByNumber/{cardNumber}";
   Boolean resualt=restTemplate.getForObject(url, Boolean.class,cardNumber);
          System.out.println("dispUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +resualt);
         return "index";
     }

    
    @RequestMapping(value = "/checkout2", method = RequestMethod.GET)
    // public String checkout(@ModelAttribute Address address,Model model,final RedirectAttributes re, HttpSession session) {
    public String checkout2(Model model, final RedirectAttributes re, HttpSession session) {
        String message = "";
        double totalPrice = 0;
        
        //........................change back to this
       // Customer c = (Customer) session.getAttribute("loggedUser");
        //------------------------------------------
        Customer c= customerService.getCustomerById(Long.valueOf(String.valueOf(1)));
        
//        if (c.getAddress().isEmpty()) {
//            //model.addAttribute("message", message);
//            model.addAttribute("message","No address, Update your profile please");
//            //re.addFlashAttribute("message", "No address, Update your profile please");
//            return "purchasingAddress";
//        }
        List<ShoppingCartItem> currentCartItems = shoppingCartService.getCustomerShoppingCart(c);

        for (ShoppingCartItem item : currentCartItems) {
            //calculate total price
            totalPrice += item.getQuantity() * item.getProduct().getPrice();
        }

        String view = "productList";

        if (currentCartItems.isEmpty()) {
            message = "Your shopping cart is Empty";
            model.addAttribute("message", message);

            return "invoice";
        } else {
            //  List<ShoppingCartItem> items = c.getShoppingCart().getShoppingCartItems();

            Date timeNow = new Date();
             
           List<OrderItem> oi= new ArrayList<OrderItem>();
            Order order = new Order();
            order.setTotalAmount(totalPrice);
            order.setOrderDate(timeNow);
            order.setOrderItem(oi);
            order = cartItemsToOrderItems(order, currentCartItems);
            order.setCustomer(c);

            c.getOrder().add(order);
        
            //save order
            orderService.addOrder(order);
             
                       
         //   salesService.addSalesDetail(profitAmount,profitToSmartMart,profitToVendor,order_itemid);
            saveSalesDetail(order);
            shoppingCartService.clearCustomerShoppingCart(c);
            
            message = "Your order has been successfully processed and $" + totalPrice + " will be deducted from your card. You will "
                    + "receive order confirmation email recently";
            model.addAttribute("message", message);
            
            return "invoice";
        }
    }

    
 
    public Order cartItemsToOrderItems(Order order, List<ShoppingCartItem> items) {

        for (ShoppingCartItem shoppingItems : items) {
            OrderItem orderItem  = new OrderItem();
            orderItem.setProduct(shoppingItems.getProduct());
            orderItem.setQuantity(shoppingItems.getQuantity());
            orderItem.setPrice(shoppingItems.getProduct().getPrice());
            
            order.addOrderItem(orderItem);
            
        }
        return order;
    }

    public void saveSalesDetail(Order order)
    {
        for(OrderItem oi : order.getOrderItem())
        {
            SalesDetail sale= new SalesDetail();
            
            sale.setOrderitem(oi);
            double total= oi.getPrice()*oi.getQuantity();
            sale.setProfitAmount(total);
            
            double profitPercentage;
            
            profitPercentage = Double.valueOf(settingsService.getSettingsValueByName("profitPercentage"));
            
            double profitToSmartMart=(profitPercentage*total)/100;
            double profitToVendor=total-profitToSmartMart;
            sale.setProfitToSmartmart(profitToSmartMart);
            sale.setProfitToVendor(profitToVendor);
            salesService.addSalesDetail(sale);
            
        }
    }

}
