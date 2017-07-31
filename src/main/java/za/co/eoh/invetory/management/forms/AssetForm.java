/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.invetory.management.forms;

import java.io.Serializable;

/**
 *
 * @author thakgatso
 */
public class AssetForm implements Serializable {
    private Integer assetID,lifeSpan;
    private String serialNo,name;
    private String type,model,comment;
    private Integer makeId;

    private String purchaseDate;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMakeId() {
        return makeId;
    }

    public void setMakeId(Integer makeId) {
        this.makeId = makeId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(Integer lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public Integer getAssetID() {
        return assetID;
    }

    public void setAssetID(Integer assetID) {
        this.assetID = assetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AssetForm{" +
            "assetID=" + assetID +
            ", serialNo='" + serialNo + '\'' +
            ", type='" + type + '\'' +
            ", makeId='" + makeId + '\'' +
            ", model='" + model + '\'' +
            ", comment='" + comment + '\'' +
            ", lifeSpan='" + lifeSpan + '\'' +
            ", purchaseDate='" + purchaseDate + '\'' +
            '}';
    }
}
