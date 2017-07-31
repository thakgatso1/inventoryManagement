/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.invetory.management.service;

import za.co.eoh.invetory.management.entity.User;

import java.util.List;

/**
 *
 * @author thakgatso
 */
public interface UserService {
     List<User> getAllUser();

  User getUserById(int id);
  
   User mergeUser(User user);

   User saveOrUpdate(User user);
User login(String username,String password);
public void  deleteUser (User user);
}
