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
public class AssetDaoHibernate extends AbstractDao<Asset, Integer>implements AssetDao {

    public AssetDaoHibernate() {
        super(Asset.class);
    }
 
}
