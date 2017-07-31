/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.invetory.management.dao;

import za.co.eoh.invetory.management.entity.User;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
  public User mergeUser(User entity) {
    getSession().merge(entity);
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

    @Override
    public User login(String username, String password) {
        String sql="from User where username=:usern and password=:pass";
        Query loginQuery=getSession().createQuery(sql);
        loginQuery.setParameter("usern",username);
        loginQuery.setParameter("pass",password);
        List<User> resultList=loginQuery.list();
        return resultList.isEmpty()?null:resultList.get(0);
    }

    
}
