package edu.mum.cs490.smartmart.controller;
 
    
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    public void setProductService(IProductService productService) {
        this.productService = productService;
    }
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
    public String deleteProduct(Model model, @PathVariable long id) {
       // ProductCategory c = productService.getProductById(id);
        Product product=productService.getProduct(id);
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

     // take it to product controller???
   @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String initalHome(Model model) {
         System.out.println("Controller");
        
     // List<Product> usr= userService.getAllUsers();
     model.addAttribute("products",productService.getAllProducts());

        return "index";
    }
    
    
    @RequestMapping(value = "/productDetail", method = RequestMethod.GET)
    public String productDetails(Model model) {
         System.out.println("Controller");
        
     // List<Product> usr= userService.getAllUsers();
    // model.addAttribute("products",productService.getAllProducts());

        return "productDetail";
    }
}
