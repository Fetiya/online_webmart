package edu.mum.cs490.smartmart.controller;

import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ShoppingCartItem;
import edu.mum.cs490.smartmart.service.ICustomerService;

 
    
import edu.mum.cs490.smartmart.domain.CategoryPropertyEditor;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.Users;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorPropertyEditor;
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
import edu.mum.cs490.smartmart.service.IShoppingCartService;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public IProductService getProductService() {
        return productService;
    }

    @Autowired
    public ICustomerService customerService;

    @Autowired
    IShoppingCartService shoppingCartService;

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


    // take it to product controller???
    @RequestMapping(value = "/index", method = RequestMethod.GET)

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(ProductCategory.class, new CategoryPropertyEditor(productCategoryService));
        binder.registerCustomEditor(Vendor.class, new VendorPropertyEditor(vendorService));
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(Product product, @RequestParam("file") MultipartFile file) {
        
        String view = "redirect:/products";
        try {
                product.setImage(file.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        System.out.println("product iname is"  + product.getName());
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

     // take it to product controller???
   @RequestMapping(value = "/index", method = RequestMethod.GET)

    public String initalHome(Model model) {
        System.out.println("Controller");

        // List<Product> usr= userService.getAllUsers();
        model.addAttribute("products", productService.getAllProducts());

        return "index";
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
              
        System.out.println("Before loop item : passed productid is " + product.getId());
        List<ShoppingCartItem> currentCartItems=shoppingCartService.getCustomerShoppingCart(customer);
        for (ShoppingCartItem item : currentCartItems) {
           System.out.println("product passed is " + product.getId());
            System.out.println("product insideloop is " +  item.getProduct().getId());
            if (item.getProduct().getId()==product.getId()) {
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

        System.out.println(" custmer name is" + customer.getFirstName());

        // List<ShoppingCartItem> cartItems= shoppingCartService.findAll();
        // model.addAttribute("cartItems",shoppingCartService.getCustomerShoppingCart(customer));
        List<ShoppingCartItem> cartItems = shoppingCartService.findAll();
        double total = 0;
        for (ShoppingCartItem i : cartItems) {
            total += i.getProduct().getPrice() * i.getQuantity();
        }
        model.addAttribute("cartItems", cartItems);

        model.addAttribute("totalPrice", total);

        return "cart";
    }


}
