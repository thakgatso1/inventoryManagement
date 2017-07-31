package za.co.eoh.invetory.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.eoh.invetory.management.dao.MakeDao;
import za.co.eoh.invetory.management.entity.Make;

import java.util.List;

@Transactional
@Service
public class MakeServiceImpl  implements  MakeService{

  @Autowired
  private MakeDao makeDao;

  @Override
  public List<Make> getAllMakes() {
    return makeDao.findAll();
  }

  @Override
  public Make findMakeById(Integer id) {
    return makeDao.findById(id);
  }
}
