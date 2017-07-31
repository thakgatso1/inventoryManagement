/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.invetory.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.eoh.invetory.management.entity.User;
import za.co.eoh.invetory.management.dao.UserDao;

import java.util.List;

/**
 *
 * @author thakgatso
 */
@Service 
@Transactional
public class UserviceImpl implements UserService{

     @Autowired
  private UserDao userDao;

    @Override
    public List<User> getAllUser() {
       return userDao.findAll(); }

    @Override
    public User getUserById(int id) {
       return userDao.findById(id);
    }

    @Override
    public User mergeUser(User user) {
        return userDao.mergeUser(user);
    }

  @Override
  public User saveOrUpdate(User user) {
    return userDao.saveOrUpdate(user);
  }

    @Override
    public void deleteUser(User user) {
    userDao.delete(user);
    }

    @Override
    public User login(String username, String password) {
     return userDao.login(username, password);
    }
    
}
