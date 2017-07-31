/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.invetory.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author thakgatso
 */
@Entity
@Table(name = "Asset")
public class Asset implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "assetID")
  private Integer assetID;

  @Column(name = "name")
  private String name;

  @Column(name = "serialNo")
  private String serialNo;

  @Column(name = "type")
  private String type;

  @Column(name = "model")
  private String model;

  @Column(name = "make_id",updatable = false,insertable = false)
  private int makeId;

  @Column(name = "purchaseDate")
  @Temporal(TemporalType.DATE)
  private Date purchaseDate;

  @Column(name = "lifeSpan")
  private Integer lifeSpan;

  @Column(name = "comment")
  private String comment;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "make_id")
  private Make make;


  public Asset() {
  }

  public Asset(Integer assetID) {
    this.assetID = assetID;
  }

  public int getMakeId() {
    return makeId;
  }

  public void setMakeId(int makeId) {
    this.makeId = makeId;
  }

  public void setMake(Make make) {
    this.make = make;
  }

  public Make getMake() {
    return make;
  }

  public Integer getAssetID() {
    return assetID;
  }

  public void setAssetID(Integer assetID) {
    this.assetID = assetID;
  }

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

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Date getPurchaseDate() {
    return purchaseDate;
  }

  public void setPurchaseDate(Date purchaseDate) {
    this.purchaseDate = purchaseDate;
  }

  public Integer getLifeSpan() {
    return lifeSpan;
  }

  public void setLifeSpan(Integer lifeSpan) {
    this.lifeSpan = lifeSpan;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Asset{" +
        "assetID=" + assetID +
        ", serialNo='" + serialNo + '\'' +
        ", type='" + type + '\'' +
        ", model='" + model + '\'' +
        ", make='" + make + '\'' +
        ", purchaseDate=" + purchaseDate +
        ", lifeSpan=" + lifeSpan +
        ", comment='" + comment + '\'' +
        '}';
  }
}
