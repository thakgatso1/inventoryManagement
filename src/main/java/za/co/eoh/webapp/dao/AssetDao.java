package za.co.eoh.webapp.dao;

import za.co.eoh.webapp.entity.Makes;

import java.util.List;
import za.co.eoh.webapp.entity.Asset;

public interface AssetDao{
    
       public Asset saveOrUpdate( Asset entity);
     public void delete( Asset entity);
     public  Asset findById(Integer id);
     public List< Asset> findAll();
}