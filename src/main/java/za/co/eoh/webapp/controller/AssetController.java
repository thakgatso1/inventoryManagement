package za.co.eoh.webapp.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.Date;
import za.co.eoh.webapp.entity.Makes;
import za.co.eoh.webapp.service.AssetService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import za.co.eoh.webapp.entity.Asset;

@Controller
@SessionAttributes("assetList")
public class AssetController {

    @Autowired
    private AssetService assetService;

//  @RequestMapping(value = "task", method = RequestMethod.GET)
//public String taskList(Map<String, Object> model) {
//        model.put("task", taskRepository.findAll());
//        return "/tasks/list";
    //}
//  @RequestMapping(value = "/listAssetsMakes.htm")
//  public String listAssets(HttpServletRequest request, Model model) throws Exception {
//        
//    List<Asset> assets = assetService.getAllAssets();
//
//    model.addAttribute("assetList", assets);
//    return "addAsset";
//  }
    @RequestMapping(value = "/viewAddAsset.htm")
    public String callViewAddAsset(Model model) {
        List<Asset> assets = assetService.getAllAssets();
     
        model.addAttribute("assetList", assets);
        model.addAttribute("addAssetForm", new AddAssetsForm());

        return "addAsset";
    }

    @RequestMapping(value = "/delete.htm")
    public String delete(@RequestParam("id") String id, Model model,  @ModelAttribute("addAssetForm") AddAssetsForm form) {
        try {
            Asset asset=new Asset();
            asset.setAssetID(Integer.parseInt(id));
       assetService.deleteAsset(asset);
       model.addAttribute("dltMsg", "Successfully deleted from the database");
        } catch (Exception exc) {

        }
        return "addAsset";
    }
    @RequestMapping(value="/updateAsset.htm")
    public String editAsset(Model model, @ModelAttribute("addAssetForm") AddAssetsForm form){
        try{
        Asset asset = new Asset();
        asset=assetService.editAsset(asset);
        asset.setPurchaseDate(new Date());

            asset.setSerialNo(form.getSerialNo());
            asset.setType(form.getType());
//
//    model.addAttribute("assetList", assets);
            asset.setMake(form.getMake());
            asset.setModel(form.getModel());
            asset.setComment(form.getComment());
            asset.setLifeSpan(Integer.parseInt(form.getLifeSpan()));
            asset = assetService.saveAsset(asset);
             List<Asset> assets = assetService.getAllAssets();
            model.addAttribute("assetList", assets);
            model.addAttribute("msg", "Successfully added to the database");
        } catch (Exception exc) {

}return  "addAsset";
    }


    @RequestMapping(value = "/addAsset.htm")
    public String addAsset(Model model, @ModelAttribute("addAssetForm") AddAssetsForm form) {
        try {
            Asset asset = new Asset();
            asset.setPurchaseDate(new Date());

            asset.setSerialNo(form.getSerialNo());
            asset.setType(form.getType());
//
//    model.addAttribute("assetList", assets);
            asset.setMake(form.getMake());
            asset.setModel(form.getModel());
            asset.setComment(form.getComment());
            asset.setLifeSpan(Integer.parseInt(form.getLifeSpan()));
            asset = assetService.saveAsset(asset);
            List<Asset> assets = assetService.getAllAssets();
            model.addAttribute("assetList", assets);
            model.addAttribute("msg", "Successfully added to the database");
        } catch (Exception exc) {

        }

        return "addAsset";
    }

}
