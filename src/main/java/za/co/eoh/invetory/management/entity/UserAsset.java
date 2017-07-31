/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.invetory.management.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
 *
 * @author thakgatso
 */
@Entity
@Table(name = "user_asset")
public class UserAsset implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_asset_id")
    private Integer userAssetID;

    @Column(name = "assignmentDate")
    @Temporal(TemporalType.DATE)
    private Date assignmentDate;

    @Column(name = "unassignDate")
    @Temporal(TemporalType.DATE)
    private Date unassignDate;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "assetID")
@NotFound(action = NotFoundAction.IGNORE)
    private Asset asset;

    @Column(name = "assetID",insertable = false,updatable = false)
    private int assetID;

    @Column(name = "userID",insertable = false,updatable = false)
    private int userID;

    public UserAsset() {
    }

    public UserAsset(Integer userAssetID) {
        this.userAssetID = userAssetID;
    }

    public UserAsset(Integer userAssetID, Date assignmentDate, Date unassignDate, String comment) {
        this.userAssetID = userAssetID;
        this.assignmentDate = assignmentDate;
        this.unassignDate = unassignDate;
        this.comment = comment;
    }

    public Integer getUserAssetID() {
        return userAssetID;
    }


    public int getAssetID() {
        return assetID;
    }

    public void setAssetID(int assetID) {
        this.assetID = assetID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserAssetID(Integer userAssetID) {
        this.userAssetID = userAssetID;
    }

    public Date getAssignmentDate() {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public Date getUnassignDate() {
        return unassignDate;
    }

    public void setUnassignDate(Date unassignDate) {
        this.unassignDate = unassignDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    @Override
    public String toString() {
        return "UserAsset{" +
            "assignmentID=" + userAssetID +
            ", assignmentDate=" + assignmentDate +
            ", unassignDate=" + unassignDate +
            ", comment='" + comment + '\'' +
            ", assetID=" + asset +
            '}';
    }
}
