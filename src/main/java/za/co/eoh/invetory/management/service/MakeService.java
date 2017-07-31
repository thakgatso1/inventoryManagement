package za.co.eoh.invetory.management.service;


import za.co.eoh.invetory.management.entity.Make;

import java.util.List;

public interface MakeService {

  List<Make> getAllMakes();
  Make findMakeById(Integer id);
}
