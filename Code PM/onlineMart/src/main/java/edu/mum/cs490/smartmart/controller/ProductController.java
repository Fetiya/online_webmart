/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.ShoppingCartItem;
import edu.mum.cs490.smartmart.service.ICustomerService;
import edu.mum.cs490.smartmart.domain.CategoryPropertyEditor;
import edu.mum.cs490.smartmart.domain.Finance;
import edu.mum.cs490.smartmart.domain.Order;
import edu.mum.cs490.smartmart.domain.OrderItem;
import edu.mum.cs490.smartmart.domain.Payment;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.SalesDetail;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorPropertyEditor;
import edu.mum.cs490.smartmart.service.INotificationService;
import edu.mum.cs490.smartmart.service.IOrderService;
import edu.mum.cs490.smartmart.service.IProductCategoryService;
import edu.mum.cs490.smartmart.service.IVendorService;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import edu.mum.cs490.smartmart.service.IProductService;
import edu.mum.cs490.smartmart.service.ISalesDetailService;
import edu.mum.cs490.smartmart.service.ISettingsService;
import edu.mum.cs490.smartmart.service.IShoppingCartService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
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
    private IProductCategoryService categoryService;
    @Autowired
    private IVendorService vendor;

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

    public IProductCategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(IProductCategoryService categoryService) {
        this.categoryService = categoryService;
    }

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

    // take it to product controller???
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String initalHome(Model model) {
            
        model.addAttribute("products", productService.getAllAvailalbleProducts());

        return "index";
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

    @RequestMapping(value = "/productEdit/{id}", method = RequestMethod.GET)
    public String getProduct(Model model, @PathVariable long id) {
        model.addAttribute("product", productService.getProduct(id));
        model.addAttribute("categories", productService.getListOfCategory());
        model.addAttribute("vendors", productService.getListOfVendor());
        return "editProduct";
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

    @RequestMapping(value = "/editProduct", method = RequestMethod.POST)
    public String updateProduct(Product product) {

        try {
            // System.out.println(product.getId());
            //  product.setImage(file.getBytes());
            productService.updateProduct(product);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "redirect:/products";

    }

    @RequestMapping(value = "/productDelete/{id}", method = RequestMethod.GET)
    public String productDelete(Model model, @PathVariable long id) {

        Product product = productService.getProduct(id);
        productService.deleteProduct(product);
        return "redirect:/products";
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

//    @RequestMapping(value = "/index", method = RequestMethod.GET)
//
//    public String initHome(Model model, HttpSession session) {
//
//        model.addAttribute("products", productService.getAllProducts());
//
//        if (session.getAttribute("guestShoppingCart") == null) {
//
//            List<ShoppingCartItem> guestShoppingCart = new ArrayList<ShoppingCartItem>();
//
//            session.setAttribute("guestShoppingCart", guestShoppingCart);
//
//        }
//        model.addAttribute("productCategory", categoryService.getAllProductCategory());
//        return "index";
//    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(ProductCategory.class, new CategoryPropertyEditor(productCategoryService));
        binder.registerCustomEditor(Vendor.class, new VendorPropertyEditor(vendorService));
    }

    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable int id, Model model, final RedirectAttributes re, HttpSession session) {

        Product product = productService.getProduct(Long.valueOf(String.valueOf(id)));

        if (session.getAttribute("loggedUser") != null) {

            addToCustomerCart(product, session);
        } // handle guest
        else {
            addToGuestCart(product, session);
        }
        String message = product.getName() + " has been added to shopping cart!";
        re.addFlashAttribute("message", message);
        return "redirect:/cart";
    }

    public void addToCustomerCart(Product product, HttpSession session) {
        
        Customer customer = (Customer) session.getAttribute("loggedUser");
        //Customer customer = customerService.getCustomerById(Long.valueOf(String.valueOf(1)));
        int quantity = 1;

        ShoppingCartItem cartItem = new ShoppingCartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setCustomer(customer);
        boolean flag = true;

        List<ShoppingCartItem> currentCartItems = shoppingCartService.getCustomerShoppingCart(customer);
        
        for (ShoppingCartItem item : currentCartItems) {

            if (item.getProduct().getId() == product.getId()) {
                //If the items are of the same product just update the quantity
                item.setQuantity(item.getQuantity() + quantity);
                shoppingCartService.updateCart(item);
                flag = false;
                break;
            }
        }
        if (flag) {
            //if the items are of different product
            customer.getShoppingCart().add(cartItem);
            
            shoppingCartService.addShoppingCart(cartItem);

        }

    }

    public void addToGuestCart(Product product, HttpSession session) {

        int quantity = 1;

        ShoppingCartItem cartItem = new ShoppingCartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        boolean flag = true;

        List<ShoppingCartItem> currentCartItems = (List<ShoppingCartItem>) session.getAttribute("guestShoppingCart");
        for (ShoppingCartItem item : currentCartItems) {

            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + quantity);

                flag = false;
                break;
            }
        }
        if (flag) {
            List<ShoppingCartItem> gcart = (List<ShoppingCartItem>) session.getAttribute("guestShoppingCart");
            gcart.add(cartItem);
        }

    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String getCustomerCart(@ModelAttribute("cartUpdate") ShoppingCartItem cartItem, Model model, HttpSession session) {

        List<ShoppingCartItem> cartItems = new ArrayList<ShoppingCartItem>();
        if (session.getAttribute("loggedUser") != null) {

            Customer customer = new Customer();
          
            customer = (Customer) session.getAttribute("loggedUser");

            cartItems = shoppingCartService.findAll();

        } else {

            cartItems = (List<ShoppingCartItem>) session.getAttribute("guestShoppingCart");

        }
        if (cartItems == null || cartItems.isEmpty()) {

            model.addAttribute("message", "Your cart is empty");

        } else {

            double total = 0;
            for (ShoppingCartItem i : cartItems) {
                total += i.getProduct().getPrice() * i.getQuantity();
            }

            model.addAttribute("cartItems", cartItems);

            model.addAttribute("totalPrice", total);

            session.setAttribute("cartAmount", total);

        }

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

//     
//     @RequestMapping(value = "/cardValidation", method = RequestMethod.POST)
//     public String Cardvalidation(String cardNumber,String securityNumber,String totalAmount,Model model, HttpSession session) {
//         System.out.println("values from cardvalidation controler"+ cardNumber+securityNumber+totalAmount);
//         boolean result;
//         RestTemplate restTemplate = new RestTemplate();
//         Payment  payment=restTemplate.getForObject("http://localhost:8080/PaymentGateWay/webresources/com.mypayment.paymentgateway.payment/checkValidation/"+cardNumber+"/"+securityNumber+"/"+totalAmount, Payment.class); 
//         if(payment.getId()!=null){
//             result=true;
//         }
//         else{
//             result=false;
//         }
//         model.addAttribute("result",result);
////         boolean result=restTemplate.getForObject(payment, );
//         System.out.println("+++++++++++"+payment.getCardNumber());
////         System.out.println("+++++++"+payment.getSecurityNumber());
////          System.out.println(result+"1111111111111111111111111111111111111");
////          if(payment){
////              return "index";
////          }
//         if(result){
//             // it will be redarected to checkout2
//             return "index";
//         }
//         else{
//           return "redirect:/checkout";  
//         }
//          }
     
     
     
      
     @RequestMapping(value = "/cardValidation", method = RequestMethod.POST)
     public String Cardvalidation(@ModelAttribute(value="payment") @Valid Payment payment,BindingResult result,Model model, HttpSession session) {
         if(result.hasErrors()){
             return "checkout";
         }
         else{
        boolean validationResult=false;
         RestTemplate restTemplate = new RestTemplate();
         Payment  validPayment=restTemplate.getForObject("http://localhost:8080/PaymentGateWay/webresources/com.mypayment.paymentgateway.payment/checkValidation/"+payment.getCardNumber()+"/"+payment.getSecurityNumber()+"/"+payment.getTotalAmount(), Payment.class); 
         if(validPayment.getId()!=null){
             validationResult=true;
         }
         
         model.addAttribute("validationResult",validationResult);
         
         System.out.println("+++++++++++"+validPayment.getCardNumber());

         if(validationResult){
             session.setAttribute("payment", "payment");
             System.out.println("session payment object "+ session.getAttribute("payment"));
             // it will be redarected to checkout2
             return "index";
         }
         else{
           return "redirect:/checkout";  
         }
          }
        }
//      @RequestMapping(value = "/dispUser/{cardNumber}", method = RequestMethod.POST)
//     public String dispUser(@PathVariable("cardNumber") String cardNumber) {
//         System.out.println("dispUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
//    RestTemplate restTemplate = new RestTemplate();
//   String url="http://localhost:8080/PaymentGateWay/webresources/com.mypayment.paymentgateway.payment/findCardByNumber/{cardNumber}";
//   Boolean resualt=restTemplate.getForObject(url, Boolean.class,cardNumber);
//          System.out.println("dispUser!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" +resualt);
//         return "index";
//     }

//    @RequestMapping(value = "/cardValidation", method = RequestMethod.POST)
//    public String Cardvalidation(String cardNumber, String securityNumber, String totalAmount, Model model, HttpSession session) {
//        System.out.println("values from cardvalidation controler" + cardNumber + securityNumber + totalAmount);
//        boolean result;
//        RestTemplate restTemplate = new RestTemplate();
//        Payment payment = restTemplate.getForObject("http://10.10.52.34:8080/PaymentGateWay/webresources/com.mypayment.paymentgateway.payment/checkValidation/" + cardNumber + "/" + securityNumber + "/" + totalAmount, Payment.class);
//        if (payment.getId() != null) {
//            result = true;
//        } else {
//            result = false;
//        }
//        model.addAttribute("result", result);
////         boolean result=restTemplate.getForObject(payment, );
//        System.out.println("+++++++++++" + payment.getCardNumber());
//
//
//        if (result) {
//            // it will be redarected to checkout2
//            return "redirect:placeOrder";
//        } else {
//            return "redirect:/checkout";
//        }
//    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.GET)
    public String placeOrder(Model model, final RedirectAttributes re, HttpSession session) {

        String message = "";
        Customer customer = new Customer();
        List<ShoppingCartItem> currentCartItems = new ArrayList<ShoppingCartItem>();

        if (session.getAttribute("loggedUser") != null) {

            Customer c = (Customer) session.getAttribute("loggedUser");
           
            currentCartItems = shoppingCartService.getCustomerShoppingCart(c);
        } else {

            currentCartItems = (List<ShoppingCartItem>) session.getAttribute("guestShoppingCart");
            customer = (Customer) session.getAttribute("guestUser");
            //persist customer, here or after orderbvalidation??
            customerService.addCustomer(customer);

        }

        if (currentCartItems.isEmpty()) {
            message = "Your shopping cart is Empty";
            model.addAttribute("message", message);

        } else {

            List<ShoppingCartItem> stockouts = checkQuantityAvailablity(currentCartItems);

            if (!stockouts.isEmpty()) {
                model.addAttribute("stockOutItems", stockouts);
                model.addAttribute("message", "Sorry, Your order couldn't be processed. The following products in your cart"
                        + " do not have available stock right now. Please edit your quantity accordingly or remove them from cart.");
                return "stockout";
            } else {

                double totalPrice = 0;

                for (ShoppingCartItem item : currentCartItems) {
                    //calculate total price

                    totalPrice += item.getQuantity() * item.getProduct().getPrice();
                }
                Date timeNow = new Date();

                List<OrderItem> oi = new ArrayList<OrderItem>();
                
                Order order = new Order();
                order.setTotalAmount(totalPrice);
                order.setOrderDate(timeNow);
                order.setOrderItem(oi);
                order = cartItemsToOrderItems(order, currentCartItems);
                order.setCustomer(customer);

                customer.getOrder().add(order);

                //save order
                orderService.addOrder(order);

                //deduct order quantity from product stock
                for (OrderItem orderItem : order.getOrderItem()) {
                    Product product = orderItem.getProduct();
                    product.setQuantity(product.getQuantity() - orderItem.getQuantity());
                    productService.updateProduct(product);
                }

                saveSalesDetail(order);

                shoppingCartService.clearCustomerShoppingCart(customer);

                if (session.getAttribute("loggedUser") == null) {

                    clearGuestShoppingCart(session);
                

                }
                message = "Your order has been successfully processed and $" + totalPrice + " will be deducted from your card. You will "
                        + "receive order confirmation email shortly";
                model.addAttribute("message", message);
                model.addAttribute("order", order);

                customerService.notifyCustomerCheckout(customer, order);

            }
        }

        return "invoice";
    }

    public Order cartItemsToOrderItems(Order order, List<ShoppingCartItem> items) {

        for (ShoppingCartItem shoppingItems : items) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(shoppingItems.getProduct());
            orderItem.setQuantity(shoppingItems.getQuantity());
            orderItem.setPrice(shoppingItems.getProduct().getPrice());

            order.addOrderItem(orderItem);

        }
        return order;
    }

    public void saveSalesDetail(Order order) {

        List<Finance> finances = new ArrayList<Finance>();

        double orderAmountToSmartmart = 0;
        for (OrderItem oi : order.getOrderItem()) {

            SalesDetail sale = new SalesDetail();

            sale.setOrderitem(oi);
            double total = oi.getPrice() * oi.getQuantity();
            sale.setProfitAmount(total);

            double profitPercentage;

            profitPercentage = Double.valueOf(settingsService.getSettingsValueByName("profitPercentage"));

            double profitToSmartMart = (profitPercentage * total) / 100;
            double profitToVendor = total - profitToSmartMart;
            sale.setProfitToSmartmart(profitToSmartMart);
            sale.setProfitToVendor(profitToVendor);
            salesService.addSalesDetail(sale);

            Finance f = new Finance(oi.getProduct().getVendor().getAccountNum(), profitToVendor, "D", new Date());

            finances.add(f);
            orderAmountToSmartmart += profitToSmartMart;
            processFinance(f);
        }

        String smartMartAccount = settingsService.getSettingsValueByName("smartMartAccoutNumber");

        Finance toSmartMart = new Finance(smartMartAccount, orderAmountToSmartmart, "D", new Date());
        finances.add(toSmartMart);
        processFinance(toSmartMart);

        // deduct from customer as well
    }

    public void readFromWS() {
        RestTemplate restTemplate = new RestTemplate();
        Finance finance = restTemplate.getForObject("http://localhost:8080/FincanceCompanyWebService/webresources/entities.finance/1", Finance.class);
        System.out.println("Name:    " + finance.getAccountNo());
        System.out.println("About:   " + finance.getAmount());
        System.out.println("Phone:   " + finance.getDate());

    }

    public void processFinance(Finance finance) {

        try {

            RestTemplate rt = new RestTemplate();
            rt.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            rt.getMessageConverters().add(new StringHttpMessageConverter());

            String uri = new String("http://localhost:8080/FincanceCompanyWebService/webresources/entities.finance");

            Finance f = new Finance();
            f.setAccountNo(finance.getAccountNo());
            f.setAmount(finance.getAmount());
            f.setDate(finance.getDate());
            f.setType(finance.getType());
            Finance returns = rt.postForObject(uri, f, Finance.class);

        } catch (HttpClientErrorException e) {

            System.out.println("error:  " + e.getResponseBodyAsString());

        } catch (Exception e) {
            System.out.println("error:  " + e.getMessage());

        }
    }

    @RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
    public String searchProductByName() {;
        return "searchProduct";
    }

    @RequestMapping(value = "/searchProduct", method = RequestMethod.POST)
    public String searchProduct(RedirectAttributes re, Model model, @Valid String productName, HttpSession session) {
        System.out.println("Produdtc Name : " + productName);
        List<Product> products = productService.getProductByName(productName);
        System.out.println("size of product " + products.size());
        if (products.size() > 0) {  //searched product found
            System.out.println("i m inside after product is saerched");

            session.setAttribute("searchProducts", products);
            return "redirect:/productResult";
        } else {
            session.setAttribute("msgs", "Product not found, please try again");
            return "redirect:/notFound";
        }
    }

    @RequestMapping(value = "/notFound")
    public String searchResult(Model model, HttpSession session) {
        model.addAttribute("msgs", session.getAttribute("msgs"));
        return "notFound";
    }

    @RequestMapping(value = "/productResult")
    public String resultNotFound(Model model, HttpSession session) {
        model.addAttribute("products", session.getAttribute("searchProducts"));
        return "productResult";
    }

    @RequestMapping(value = "/navigation", method = RequestMethod.GET)
    public String showNavigation(Model model) {
        model.addAttribute("categories", categoryService.getAllProductCategory());
        model.addAttribute("vendor", vendor.getAllVendors());
        return "navigation";
    }

    @RequestMapping(value = "getProductsByVendor/{vid}/{cid}", method = RequestMethod.GET)
    public String getProductByVendor(Model model, @PathVariable long vid, @PathVariable long cid, HttpSession session) {
        Vendor v = vendor.getVendorById(vid);
        ProductCategory c = categoryService.getProductCategoryById(cid);
        List<Product> productList = productService.getProductByVendorCategoryId(v, c);
        session.setAttribute("productlist", productList);
        return "redirect:/productByVendor";

    }

    @RequestMapping(value = " getProductByVendorOnly/{vid}", method = RequestMethod.GET)
    public String getProductByVendor(Model model, @PathVariable long vid, HttpSession session) {
        Vendor v = vendor.getVendorById(vid);
        List<Product> productList = productService.getProductByVendor(v);
        session.setAttribute("productlist", productList);
        return "redirect:/productByVendor";

    }

    @RequestMapping(value = "/productByVendor")
    public String productByVendor(Model model, HttpSession session) {
        model.addAttribute("productlist", session.getAttribute("productlist"));
        return "productByVendor";
    }

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public String VendorList(Model model) {
        List<Vendor> v = vendor.getAllVendors();
        model.addAttribute("vendorList", v);
        System.out.println(v.size());
        return "brands";
    }

    public List<ShoppingCartItem> checkQuantityAvailablity(List<ShoppingCartItem> cartItems) {

        List<ShoppingCartItem> stockouts = new ArrayList<ShoppingCartItem>();
        for (ShoppingCartItem ci : cartItems) {
            if (!(ci.getProduct().getQuantity() >= ci.getQuantity())) {
                stockouts.add(ci);
            }
        }

        return stockouts;
    }

    @RequestMapping(value = "/cart/edit/{id}", method = RequestMethod.POST)
    public String editCart(Model model, @PathVariable long id, String quantity, HttpSession session) {

        try {
            Integer.valueOf(quantity);

            int qty = Integer.valueOf(quantity);

        } catch (Exception e) {

            session.setAttribute("message", "Error: Your shopping cart is not updated. '" + quantity + "' is not a valid quantity");
            return "redirect:/cart";
        }
        session.setAttribute("message", "");

        ShoppingCartItem cart = new ShoppingCartItem();

        if (session.getAttribute("loggedUser") != null) {

            cart = shoppingCartService.getShoppingCartByProduct(id);

            cart.setQuantity(Integer.valueOf(quantity));

            shoppingCartService.updateCart(cart);

        } else {

            List<ShoppingCartItem> items = (List<ShoppingCartItem>) session.getAttribute("guestShoppingCart");

            for (ShoppingCartItem cartItem : items) {

                if (cartItem.getProduct().getId() == id) {

                    cart = cartItem;

                    cart.setQuantity(Integer.valueOf(quantity));

                    break;

                }
            }
        }

        return "redirect:/cart";

    }

    @RequestMapping(value = "/cart/delete/{id}", method = RequestMethod.GET)
    public String deleteCartItem(@PathVariable Long id, Model model, HttpSession session) {

        if (session.getAttribute("loggedUser") != null) {

            ShoppingCartItem item = shoppingCartService.getShoppingCartByProduct(id);

            shoppingCartService.deleteShoppingCartItem(item);

        } else {
            List<ShoppingCartItem> items = (List<ShoppingCartItem>) session.getAttribute("guestShoppingCart");

            for (ShoppingCartItem cartItem : items) {

                if (cartItem.getProduct().getId() == id) {

                    items.remove(cartItem);

                    break;

                }
            }

        }

        return "redirect:/cart";
    }

    public void clearGuestShoppingCart(HttpSession session) {
       
        List<ShoppingCartItem> items = (List<ShoppingCartItem>) session.getAttribute("guestShoppingCart");
        items.clear();

    }
}

