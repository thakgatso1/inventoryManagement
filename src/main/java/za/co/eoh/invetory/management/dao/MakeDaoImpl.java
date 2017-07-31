package za.co.eoh.invetory.management.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import za.co.eoh.invetory.management.entity.Make;

import java.util.List;
@Repository
public class MakeDaoImpl implements  MakeDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public Make findById(Integer id) {
    return (Make) getSession().get(Make.class, id);
  }

  @Override
  public List<Make> findAll() {
    return (List<Make>) getSession().createCriteria(Make.class).list();
  }

  Session getSession() {
    return sessionFactory.getCurrentSession();
  }
}
