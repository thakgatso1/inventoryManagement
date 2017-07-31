package za.co.eoh.invetory.management.dao;

import za.co.eoh.invetory.management.entity.Make;

import java.util.List;

public interface MakeDao {

  public Make findById(Integer id);
  public List< Make> findAll();
}
