package za.co.eoh.webapp.service;

import za.co.eoh.webapp.entity.Makes;

import java.util.List;
import za.co.eoh.webapp.entity.Asset;

public interface AssetService {
  
  List<Asset> getAllAssets();

  Asset getAssetById(int id);
  
   Asset saveOrUpdateAsset(Asset asset);

public void  deleteAsset (Asset asset);

}
