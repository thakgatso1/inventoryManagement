/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.webapp.service;

import java.util.List;
import za.co.eoh.webapp.entity.Asset;
import za.co.eoh.webapp.entity.User;

/**
 *
 * @author thakgatso
 */
public interface UserService {
     List<User> getAllUser();

  User getUserById(int id);
  
   User saveOrUpdateUser(User user);

public void  deleteUser (User user);
}
