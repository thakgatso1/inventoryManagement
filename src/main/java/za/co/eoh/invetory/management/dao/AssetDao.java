package za.co.eoh.invetory.management.dao;

import za.co.eoh.invetory.management.entity.Asset;

import java.util.List;

public interface AssetDao{
    
       public Asset saveOrUpdate( Asset entity);
     public void delete( Asset entity);
     public  Asset findById(Integer id);
     public List< Asset> findAll();
}