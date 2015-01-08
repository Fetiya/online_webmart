/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.dao.impl;

import edu.mum.cs490.smartmart.dao.GenericDAOImpl;
import edu.mum.cs490.smartmart.dao.IProductDAO;
import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Product;
import edu.mum.cs490.smartmart.domain.ProductCategory;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.report.entity.ProductSales;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fetiya
 */
public class ProductDAOImpl extends GenericDAOImpl<Product, Long> implements IProductDAO {

//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("edu.mum.cs490_onlineMart_war_1.0-SNAPSHOTPU");
    public ProductDAOImpl() {
        super(Product.class);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Product> getProductByName(String name) {
        System.out.println("i m in product dao");
        List<Product> product;
        Query query = getSf().getCurrentSession().createQuery(" from Product p where p.name=name");
        //  query.setParameter("name", name);

        System.out.println("hereeee" + query.list());
        //query.setString("theName",name);
        product = query.list();
        System.out.println("i m in product dao adter r");
        return product;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Product> getProductByCatId(long categoryId) {
        List<Product> product;
        Query query = getSf().getCurrentSession().createQuery(" from Product p where p.productCategory_id=categoryId");
        product = query.list();
        return product;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Product> getProductByVendorCategoryId(Vendor v, ProductCategory c) {
        List<Product> product;

        Query query = getSf().getCurrentSession().createQuery("select p  from Product p where p.vendor=:v AND p.productCategory=:c");
        query.setParameter("v", v);
        query.setParameter("c", c);
        product = query.list();
        System.out.println("size of product Array: " + product.size());
        return product;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Product> getProductByVendor(Vendor v) {
        List<Product> product;
        Query query = getSf().getCurrentSession().createQuery("select p  from Product p where p.vendor=:v ");
        query.setParameter("v", v);
        product = query.list();
        System.out.println("size of product Array: " + product.size());
        return product;
    }

    public List<ProductSales> getPrductsSalesByVendor(long vendorId,Calendar startDate, Calendar endDate) {
//        Query query = getSf().getCurrentSession().createQuery(
//                "SELECT new ProductSales(o.product.id, o.product.name, o.product.quantity , sum(o.quantity) as qtySold, sum(o.price) as totalPrice, sum(o.salesDetail.profitToVendor) as totalNetIncome)"
//                + " FROM OrderItem o"
//                + " WHERE o.product.vendor.id= " + vendorId
//                + " GROUP BY o.product.id");
//        List<ProductSales> result = query.list();

//        EntityManager em = emf.createEntityManager();
//        List<ProductSales> result=em.createQuery("SELECT new ProductSales(o.product.id, o.product.name, o.product.quantity , sum(o.quantity) as qtySold, sum(o.price) as totalPrice, sum(o.salesDetail.profitToVendor) as totalNetIncome)"
//                + " FROM OrderItem o"
//                + " WHERE o.product.vendor.id= " + vendorId
//                + " GROUP BY o.product.id", ProductSales.class).getResultList();
        //.getResultList()
        String sql = "SELECT p.id as productId, p.name as productName, p.quantity as qtyInStock , sum(o.quantity) as qtySold, sum(o.price * o.quantity) as totalPrice, sum(s.profitToVendor) as totalNetIncome"
                + " FROM orderitem o,product p,salesdetail s, order_table ot"
                + " WHERE o.product_id=p.id and o.id=s.`orderItem_id` and p.vendor_id = v.id and v.id="+vendorId+" and ot.`orderDate` >= '"+startDate+"' AND ot.`orderDate` < '"+endDate+"' "
                + " GROUP BY p.id";
        Query query = getSf().getCurrentSession().createSQLQuery(sql);
        List<Object[]> listResult = query.list();
        List<ProductSales> result = new ArrayList<>();

        for (Object[] aRow : listResult) {
            ProductSales productSales = new ProductSales(((BigInteger)aRow[0]).longValue(), (String) aRow[1], (Integer)aRow[2], ((BigDecimal)aRow[3]).intValue(), (Double)aRow[4], (Double)aRow[5]);
            result.add(productSales);
        }
        return result;
    }

}
