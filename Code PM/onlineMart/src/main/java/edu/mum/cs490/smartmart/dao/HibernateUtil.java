package edu.mum.cs490.smartmart.dao;


import edu.mum.cs490.smartmart.domain.Address;
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
//    public String addAuction() {
//
//         Address address1=new Address();
//        address1.setCity("Fairfield");
//        address1.setCountry("US");
//        address1.setStreet("1000N 4th stree");
//        address1.setZip(52557);
//       
//        IAddressDAO addressDAO = new 
//
//        auctionDao.beginTransaction();
//        auctionDao.save(auction);
//        auctionDao.commitTransaction();
//
//        return "auctionConfirmation.xhtml";
//    }

    public static void main(String[] Args) {
        HibernateUtil.recreateDatabase();
       
       
        
    }
    
}
