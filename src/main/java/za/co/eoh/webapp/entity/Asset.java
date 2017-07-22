/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.webapp.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thakgatso
 */
@Entity
@Table(name = "Asset")
public class Asset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "assetID")
    private Integer assetID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "serialNo")
    private String serialNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "make")
    private String make;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchaseDate")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "lifeSpan")
    private int lifeSpan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "comment")
    private String comment;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assetID")
    private List<UserAsset> assignmentList;

    public Asset() {
    }

    public Asset(Integer assetID) {
        this.assetID = assetID;
    }

    public Asset(Integer assetID, String serialNo, String type, String model, String make, Date purchaseDate, int lifeSpan, String comment) {
        this.assetID = assetID;
        this.serialNo = serialNo;
        this.type = type;
        this.model = model;
        this.make = make;
        this.purchaseDate = purchaseDate;
        this.lifeSpan = lifeSpan;
        this.comment = comment;
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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(int lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public List<UserAsset> getAssignmentList() {
        return assignmentList;
    }

    public void setAssignmentList(List<UserAsset> assignmentList) {
        this.assignmentList = assignmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assetID != null ? assetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asset)) {
            return false;
        }
        Asset other = (Asset) object;
        if ((this.assetID == null && other.assetID != null) || (this.assetID != null && !this.assetID.equals(other.assetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.eoh.webapp.entity.Asset[ assetID=" + assetID + " ]";
    }

    
}
