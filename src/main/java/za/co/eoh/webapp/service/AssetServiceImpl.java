package za.co.eoh.webapp.service;

import za.co.eoh.webapp.dao.AssetDao;
import za.co.eoh.webapp.entity.Makes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.eoh.webapp.entity.Asset;

@Service
public class AssetServiceImpl implements AssetService {

  @Autowired
  private AssetDao assetDao;

  @Override
  @Transactional(readOnly = true)
  public List<Asset> getAllAssets() {

    return assetDao.findAll();

  }
 @Transactional
    public Asset saveAsset(Asset asset) {
        return assetDao.save(asset);
          }

    @Transactional
    public Asset editAsset(Asset asset) {
        
return assetDao.edit(asset);
}
    @Transactional
    public void deleteAsset(Asset asset){
        assetDao.delete(asset);
    }
}