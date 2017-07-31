/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.invetory.management.dao;

import za.co.eoh.invetory.management.entity.User;

import java.util.List;

/**
 *
 * @author thakgatso
 */
public interface UserDao {
     public User saveOrUpdate(User entity);
     User mergeUser(User entity);
     public User login(String username,String password);
     public void delete( User entity);
     public  User findById(Integer id);
     public List< User> findAll();
}
