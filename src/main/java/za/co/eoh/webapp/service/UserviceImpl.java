/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.webapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.eoh.webapp.dao.AssetDao;
import za.co.eoh.webapp.dao.UserDao;
import za.co.eoh.webapp.entity.User;

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
    public User saveOrUpdateUser(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(User user) {
    userDao.delete(user);
    }
    
}
