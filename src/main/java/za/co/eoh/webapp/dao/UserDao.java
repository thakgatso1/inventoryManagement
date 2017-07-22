/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.webapp.dao;

import java.util.List;
import za.co.eoh.webapp.entity.Asset;
import za.co.eoh.webapp.entity.User;

/**
 *
 * @author thakgatso
 */
public interface UserDao {
     public User saveOrUpdate( User entity);
     public void delete( User entity);
     public  User findById(Integer id);
     public List< User> findAll();
}
