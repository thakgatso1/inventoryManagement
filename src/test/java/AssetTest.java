import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.eoh.invetory.management.entity.Asset;
import za.co.eoh.invetory.management.entity.Make;
import za.co.eoh.invetory.management.service.AssetService;

import java.util.List;

@ContextConfiguration("classpath:spring-config.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AssetTest {

  @Autowired
  private AssetService assetService;

  @Test
  @Ignore
  public  void testFindAssetById()
  {
    try {
      Asset asset=assetService.getAssetById(1);
      Assert.assertNotNull(asset);
      Assert.assertNotNull(asset.getMake());
      System.out.println(asset);

    }
    catch (Exception ex)
    {
      Assert.fail("test add asset failed: "+ex.getMessage());
      ex.printStackTrace();

    }
  }
  @Test
@Ignore
  public void testAddAsset()
  {
    Asset asset=new Asset();

    Make make=new Make();
    make.setId(1);
asset.setName("TEst Name");
    asset.setSerialNo("SN12345");
    asset.setModel("DN");
    asset.setMake(make);

    try {
      assetService.saveOrUpdateAsset(asset);
      Assert.assertNotNull(asset);
      System.out.println(asset);
    }
    catch (Exception ex)
    {
      Assert.fail("test add asset failed: "+ex.getMessage());
      ex.printStackTrace();

    }
;
  }

  @Test
  @Ignore
  public void testUpdateAsset()
  {
    Asset asset=new Asset();
  asset.setAssetID(24);
    Make make=new Make();
    make.setId(2);

    asset.setSerialNo("SN123465");
    asset.setModel("DN");
    asset.setMake(make);

    try {
      assetService.saveOrUpdateAsset(asset);
      System.out.println(asset);

    }
    catch (Exception ex)
    {
      Assert.fail("test update asset failed: "+ex.getMessage());
      ex.printStackTrace();

    }
  }

  @Test
  @Ignore
  public void testFindAllAssets()
  {

    try {
      List<Asset> assets= assetService.getAllAssets();
      Assert.assertNotNull(assets);
      Assert.assertFalse(assets.isEmpty());
      System.out.println(assets);
    }
    catch (Exception ex)
    {
      Assert.fail("test find all assets failed: "+ex.getMessage());
      ex.printStackTrace();

    }
  }

  @Test
  @Ignore
  public  void testDeleteAsset()
  {
    Asset asset=new Asset(35);
    Make make=new Make();
    make.setId(1); //MAke must not be deleted
    try {
      assetService.deleteAsset(asset);
    }
    catch (Exception ex)
    {
      Assert.fail("test delete asset failed: "+ex.getMessage());
      ex.printStackTrace();
    }
  }
}
