package za.co.eoh.invetory.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.eoh.invetory.management.dao.AssetDao;
import za.co.eoh.invetory.management.entity.Asset;

import java.util.List;

@Service
public class AssetServiceImpl implements AssetService {

  @Autowired
  private AssetDao assetDao;

  @Override
  @Transactional(readOnly = true)
  public List<Asset> getAllAssets() {

    return assetDao.findAll();

  }

    @Override
    @Transactional(readOnly = true)
    public Asset getAssetById(int id) {
      return assetDao.findById(id);
    }
  
  
  
 @Transactional
    public Asset saveOrUpdateAsset(Asset asset) {
        return assetDao.saveOrUpdate(asset);
          }

 
    @Transactional
    public void deleteAsset(Asset asset){
        assetDao.delete(asset);
    }
}