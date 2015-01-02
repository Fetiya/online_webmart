package edu.mum.cs490.smartmart.dao;

import java.util.*;
import java.io.*;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//@Repository
public abstract class GenericDAOImpl< T, ID extends Serializable> implements GenericDAO<T, ID> {

    
   // @Autowired
    private SessionFactory sf;

    public SessionFactory getSf() {
        return sf;
    }

    


    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    private Class<T> persistenceClass;

    public GenericDAOImpl(Class c) {
        this.persistenceClass = c;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public T findByPrimaryKey(ID id) {
        // return (T) HibernateUtil.getSession().load(persistenceClass, id);
        return (T) sf.getCurrentSession().load(persistenceClass, id);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        Criteria crit = sf.getCurrentSession().createCriteria(persistenceClass);
        Example example = Example.create(exampleInstance);
        if (excludeProperty != null) {
            for (int i = 0; i < excludeProperty.length; i++) {
                example.excludeProperty(excludeProperty[i]);
            }
        }
        crit.add(example);
        return crit.list();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<T> findAll(int startIndex, int fetchSize) {
        Criteria crit = sf.getCurrentSession().createCriteria(persistenceClass);
        crit.setFirstResult(startIndex);
        crit.setFetchSize(fetchSize);
        System.out.println("......................." + crit.list());
        return crit.list();
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public T save(T entity) {
        sf.getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void delete(T entity) {
        sf.getCurrentSession().delete(entity);
    }

}
