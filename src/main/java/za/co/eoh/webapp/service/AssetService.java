package za.co.eoh.webapp.service;

import za.co.eoh.webapp.entity.Makes;

import java.util.List;
import za.co.eoh.webapp.entity.Asset;

public interface AssetService {
  
  List<Asset> getAllAssets();

   Asset saveAsset(Asset asset);
 Asset editAsset (Asset asset);
public void  deleteAsset (Asset asset);

}
