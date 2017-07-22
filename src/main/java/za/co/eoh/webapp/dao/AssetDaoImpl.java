package za.co.eoh.webapp.dao;

import za.co.eoh.webapp.entity.Makes;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import za.co.eoh.webapp.entity.Asset;

@Repository
public class AssetDaoImpl implements AssetDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Asset saveOrUpdate(Asset entity) {
      getSession().saveOrUpdate(entity);
      return entity;      
    }

    public List<Asset> findAll() {

        return (List<Asset>) getSession().createCriteria(Asset.class).list();

    }
    
 
   
public Asset findById(Integer id){
     return (Asset)getSession().get(Asset.class, id);
   
}
   
    public void delete(Asset entity) {
         
        getSession().delete(entity);
    }
        
     Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
