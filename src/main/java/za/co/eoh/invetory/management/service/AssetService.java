package za.co.eoh.invetory.management.service;

import za.co.eoh.invetory.management.entity.Asset;

import java.util.List;

public interface AssetService {
  
  List<Asset> getAllAssets();

  Asset getAssetById(int id);
  
   Asset saveOrUpdateAsset(Asset asset);

public void  deleteAsset (Asset asset);

}
