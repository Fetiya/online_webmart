package edu.mum.cs490.smartmart.dao;

import java.io.Serializable;
import java.util.List;

interface IGenericDAO< T, ID extends Serializable> {
   
    T findByPrimaryKey(ID id);
 
    List<T> findAll(int startIndex, int fetchSize);
    
    List<T> findAll();

    List<T> findByExample(T exampleInstance, String[] excludeProperty);

    T save(T entity);

    void delete(T entity);


}
