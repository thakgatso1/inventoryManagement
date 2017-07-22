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
import org.springframework.stereotype.Repository;
import za.co.eoh.webapp.entity.Asset;
import za.co.eoh.webapp.entity.User;

/**
 *
 * @author thakgatso
 */
@Repository
public class UserDaoImpl implements UserDao{
     @Autowired
    private SessionFactory sessionFactory;

    public User saveOrUpdate(User entity) {
      getSession().saveOrUpdate(entity);
      return entity;      
    }

     @Override
    public List<User> findAll() {

        return (List<User>) getSession().createCriteria(User.class).list();

    }
    
 
   
     @Override
     public User findById(Integer id){
     return (User)getSession().get(User.class, id);
   
}
   
    public void delete(User entity) {
         
        getSession().delete(entity);
    }
        
    Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    
}
