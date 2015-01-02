
package edu.mum.cs490.smartmart.dao;

public abstract class DAOFactory {

    public static final Class FACTORY_CLASS = edu.mum.cs490.smartmart.dao.HibernateDAOFactory.class;

    public static DAOFactory getFactory() {
        try {
            return (DAOFactory) FACTORY_CLASS.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Couldn't create factory");
        }
    }

//    public abstract UserDAO getUserDAO();

}
