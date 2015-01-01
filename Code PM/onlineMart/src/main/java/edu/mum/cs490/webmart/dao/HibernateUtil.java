package edu.mum.cs490.webmart.dao;

import edu.mum.cs490.webmart.domain.*;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

    private static SessionFactory factory;

    public static Configuration getInitializedConfiguration() {
        AnnotationConfiguration config = new AnnotationConfiguration();

        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Address.class);
        config.addAnnotatedClass(Admin.class);
        config.addAnnotatedClass(Credentials.class);
        config.addAnnotatedClass(Customer.class);
        config.addAnnotatedClass(Order.class);
        config.addAnnotatedClass(OrderItem.class);
        config.addAnnotatedClass(PaymentInfo.class);
        config.addAnnotatedClass(Product.class);
        config.addAnnotatedClass(ProductCategory.class);
        config.addAnnotatedClass(Role.class);
        config.addAnnotatedClass(SalesDetail.class);
        config.addAnnotatedClass(Settings.class);
        config.addAnnotatedClass(ShoppingCartItem.class);
        config.addAnnotatedClass(SubscriptionRule.class);
        config.addAnnotatedClass(Vendor.class);
        config.addAnnotatedClass(VendorAdmin.class);
        config.configure();

        return config;
    }

    public static Session getSession() {
        if (factory == null) {
            Configuration config = HibernateUtil.getInitializedConfiguration();
            factory = config.buildSessionFactory();
        }
        Session hibernateSession = factory.getCurrentSession();

        return hibernateSession;
    }

    public static void recreateDatabase() {
        Configuration config = HibernateUtil.getInitializedConfiguration(); //WE dont need session in creating schema, we need session in persisting
        new SchemaExport(config).create(true, true);
    }

    public static Session beginTransaction() {
        Session hibernateSession = HibernateUtil.getSession();
        hibernateSession.beginTransaction();
        return hibernateSession;
    }

    public static void commitTransaction() {
        HibernateUtil.getSession().getTransaction().commit();
    }

    public static void rollbackTransaction() {
        HibernateUtil.getSession().getTransaction().rollback();
    }

    public static void closeSession() {
        HibernateUtil.getSession().close();
    }

    public static void main(String[] Args) {
        HibernateUtil.recreateDatabase();
    }
}
