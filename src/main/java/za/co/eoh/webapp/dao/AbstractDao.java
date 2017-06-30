/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.webapp.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.eoh.webapp.entity.Asset;

/**
 *
 * @author thakgatso
 */
public class AbstractDao<E,ID> {

    private Class<?> entityClazz;

    public AbstractDao(Class<?> entityClazz) {
        this.entityClazz = entityClazz;
    }
    
    @Autowired
    private SessionFactory sessionFactory;

    public E save(E entity) {
      getSession().save(entity);
      return entity;      
    }

    public List<E> findAll() {

        return (List<E>) getSession().createCriteria(entityClazz).list();

    }
  
    public Asset edit(Asset entity) {
   getSession().saveOrUpdate(entity);
      return entity;  
        }

   
    public void delete(Asset entity) {
         
        getSession().delete(entity);
    }
        
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
