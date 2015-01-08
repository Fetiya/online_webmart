package edu.mum.cs490.smartmart.dao;

import edu.mum.cs490.smartmart.dao.impl.VendorDAOImpl;
import edu.mum.cs490.smartmart.domain.Address;
import edu.mum.cs490.smartmart.domain.Credential;
import edu.mum.cs490.smartmart.domain.Role;
import edu.mum.cs490.smartmart.domain.SubscriptionRule;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.domain.VendorAdmin;
import edu.mum.cs490.smartmart.domain.VendorStatus;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateUtil {

    private static SessionFactory factory;
    //private DAOFactory factory = DAOFactory.getFactory();

    @Autowired
    private static IVendorDAO vendorDao;
//    @Autowired
//    private IAdminDAO vendorDao;
    @Autowired
    private static ICustomerDAO customerDao;
    @Autowired
    private static IProductCategoryDAO productCategoryDao;
    @Autowired
    private static IProductDAO productDao;
    @Autowired
    private static IOrderDAO orderDao;
    @Autowired
    private static ISalesDetailDAO salesDeatailDao;
    @Autowired
    private static ISettingsDAO settingsDao;
    @Autowired
    private static IShoppingCartItemDAO shoppingCartItemDao;
    @Autowired
    private static ISubscriptionRuleDAO subscriptionRuleDao;

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

    private void createSampleSettings() {

    }

    private void createSampleAdmin() {

    }

    private static void createSampleVendor() {

        SubscriptionRule subscriptionRule1 = new SubscriptionRule();
        subscriptionRule1.setRangeProduct(100);
        subscriptionRule1.setFee(1000);
        subscriptionRuleDao.save(subscriptionRule1);

        Vendor vendor1 = new Vendor();
        vendor1.setAccountNum("dell200000000");
        vendor1.setCompanyName("DELL");
        vendor1.setStatus(VendorStatus.PENDING);

        Address address1 = new Address();
        address1.setCity("Fairfield");
        address1.setCountry("US");
        address1.setStreet("1000N 4th stree");
        address1.setZip(52557);
        
        
        Credential cred=new Credential();
        cred.setUsername("Komal");
        cred.setPassword("Komal");
        cred.setActive(true);
        cred.setRole(Role.ROLE_VENDORADMIN);
        
        VendorAdmin vAdmin=new VendorAdmin();
        vAdmin.setFirstName("Komal");
        vAdmin.setMiddleName("Komal");
        vAdmin.setLastName("Ashraf");
        vAdmin.setTelnum("2345234");
        
        vAdmin.setCredential(cred);
        vAdmin.setAddress(address1);
        vAdmin.setVendor(vendor1);

        vendor1.setAddress(address1);
        vendor1.setSubscriptionRule(subscriptionRule1);
        vendor1.setVendorAdmin(vAdmin);
        vendorDao.save(vendor1);

        vendor1 = new Vendor();
        vendor1.setAccountNum("HP200000000");
        vendor1.setCompanyName("HP");
        vendor1.setStatus(VendorStatus.ACTIVE);
        vendor1.setSubscriptionRule(subscriptionRule1);
        vendor1.setAddress(address1);
        
        cred=new Credential();
        cred.setUsername("Senai");
        cred.setPassword("Senai");
        cred.setActive(true);
        cred.setRole(Role.ROLE_VENDORADMIN);
        
        vAdmin=new VendorAdmin();
        vAdmin.setFirstName("Senai");
        vAdmin.setMiddleName("Senai");
        vAdmin.setLastName("A");
        vAdmin.setTelnum("2345234");
        
        vAdmin.setCredential(cred);
        vAdmin.setAddress(address1);
        vAdmin.setVendor(vendor1);

        vendor1.setAddress(address1);
        vendor1.setSubscriptionRule(subscriptionRule1);
        vendor1.setVendorAdmin(vAdmin);
        
        vendorDao.save(vendor1);

    }

    private void createSampleCustomer() {

    }

    private void createSampleProductCategory() {

    }

    private void createSampleProduct() {

    }

    private void createSamplePurchase() {

    }

    public static void main(String[] Args) {
        createSampleVendor();

    }

}
