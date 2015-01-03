package edu.mum.cs490.smartmart.dao;


import edu.mum.cs490.smartmart.dao.impl.AddressDAOImpl;
import edu.mum.cs490.smartmart.dao.impl.SubscriptionRuleDAOImpl;
import edu.mum.cs490.smartmart.dao.impl.VendorDAOImpl;
import edu.mum.cs490.smartmart.domain.Address;
import edu.mum.cs490.smartmart.domain.SubscriptionRule;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorStatus;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
    
    private static SessionFactory factory;
    //private DAOFactory factory = DAOFactory.getFactory();

   
    
    public static Configuration getInitializedConfiguration() {
        AnnotationConfiguration config = new AnnotationConfiguration();

 //       config.addAnnotatedClass(User.class);
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
        
       Address address1=new Address();
        address1.setCity("Fairfield");
        address1.setCountry("US");
        address1.setStreet("1000N 4th stree");
        address1.setZip(52557);
       
        IAddressDAO addressDAO = new AddressDAOImpl();
        addressDAO.save(address1);
        
        SubscriptionRule subscriptionRule1=new SubscriptionRule();
        subscriptionRule1.setRangeProduct(100);
       subscriptionRule1.setFee(1000);
       ISubscriptionRuleDAO subscriptionDAO= new SubscriptionRuleDAOImpl();
       subscriptionDAO.save(subscriptionRule1);
         

         Vendor vendor1=new Vendor();
       vendor1.setAccountNum("dell200000000");
       vendor1.setAddress(address1);
       vendor1.setCompanyName("DELL");
       vendor1.setEmail("dell@gmail.com");
       vendor1.setStatus(VendorStatus.PENDING);
       vendor1.setSubscriptionRule(subscriptionRule1);
       
       VendorDAO vendorDAO= new VendorDAOImpl();
       vendorDAO.save(vendor1);
        
    }
    
}
