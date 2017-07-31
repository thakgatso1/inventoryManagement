package za.co.eoh.invetory.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import za.co.eoh.invetory.management.entity.Asset;
import za.co.eoh.invetory.management.entity.Make;
import za.co.eoh.invetory.management.forms.AssetForm;
import za.co.eoh.invetory.management.service.AssetService;
import za.co.eoh.invetory.management.service.MakeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"assetList", "assetForm", "makes"})
@RequestMapping(value = "/assets")
public class AssetController {

  @Autowired
  private AssetService assetService;

  @Autowired
  private MakeService makeService;

  @RequestMapping(value = "/viewAssets.htm")
  public String viewAssets(Model model) {
    List<Asset> assets = assetService.getAllAssets();
    model.addAttribute("assetList", assets);
    return "admin/assets/viewAssets";
  }

  @RequestMapping(value = "/delete.htm")
  public String delete(@RequestParam(value = "id") Integer id, Model model) throws Exception {
    try {
      Asset asset = new Asset(id);
      assetService.deleteAsset(asset);
      model.addAttribute("assetMessage", "Asset with id: " + asset.getAssetID() + " successfully deleted");
    } catch (Exception exc) {
      model.addAttribute("assetError", "Failed to delete Asset, most likely because it is still assigned to a user.");
    }
    return viewAssets(model);
  }

  @RequestMapping(value = "/viewUpdateAsset.htm")
  public String viewUpdateAssetPage(Model model, @RequestParam(value = "id") Integer id) {
    System.out.println("viewAddUpdateAssetForm: " + id);
    Asset asset = assetService.getAssetById(id);
    AssetForm assetForm = new AssetForm();
    if (asset != null) {
      assetForm.setAssetID(id);
      assetForm.setComment(asset.getComment());
      assetForm.setLifeSpan(asset.getLifeSpan());
      assetForm.setName(asset.getName());
      if (asset.getMake() != null) {
        assetForm.setMakeId(asset.getMake().getMakeId());
      }
      assetForm.setModel(asset.getModel());

      if (asset.getPurchaseDate() != null) {
        assetForm.setPurchaseDate(asset.getPurchaseDate().toString());
      }
      assetForm.setSerialNo(asset.getSerialNo());
      assetForm.setType(asset.getType());
    }
    model.addAttribute("assetForm", assetForm);
    model.addAttribute("makes", makeService.getAllMakes());
    return "admin/assets/addUpdateAssets";
  }

  @RequestMapping(value = "/viewAddAsset.htm")
  public String viewAddAssetPage(Model model) {
    model.addAttribute("assetForm", new AssetForm());
    model.addAttribute("makes", makeService.getAllMakes());
    return "admin/assets/addUpdateAssets";
  }


  @RequestMapping(value = "/addUpdateAsset.htm")
  public String addOrUpdateAsset(Model model, @ModelAttribute("assetForm") AssetForm form) {
    try {
      Asset asset = new Asset(form.getAssetID());
      Date pDate=new Date();
      if (form.getPurchaseDate() != null) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Date: " + form.getPurchaseDate());
        try {
          pDate = fmt.parse(form.getPurchaseDate());
        } catch (ParseException e) {
          e.printStackTrace();
        }
      }
      asset.setPurchaseDate(pDate);

      asset.setSerialNo(form.getSerialNo());
      asset.setType(form.getType());
      asset.setModel(form.getModel());
      asset.setComment(form.getComment());
      asset.setLifeSpan(form.getLifeSpan());
      Make make = new Make();
      make.setId(form.getMakeId());
      asset.setMake(make);
      asset.setName(form.getName());
      assetService.saveOrUpdateAsset(asset);
      model.addAttribute("assetMessage", "Asset with id: " + asset.getAssetID() + " added/updated successfully");
    } catch (Exception exc) {
      model.addAttribute("assetError", "Failed to add or update Asset: "+exc.getMessage());
      exc.printStackTrace();
    }
    return viewAssets(model);
  }

}
