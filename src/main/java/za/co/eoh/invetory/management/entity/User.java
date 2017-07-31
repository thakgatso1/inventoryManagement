/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.invetory.management.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author thakgatso
 */
@Entity
@Table(name = "User")

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Integer userID;
   

    @Column(name = "username")
    private String username;

    

    @Column(name = "password")
    private String password;
   

    @Column(name = "businessUnt")
    private String businessUnt;
    

    @Column(name = "comment")
    private String comment;


    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    @ManyToOne
    @JoinColumn(name="userRole_roleID",referencedColumnName = "roleID")
    @Fetch(FetchMode.JOIN)
    private Role userRole;

    @OneToMany(cascade = CascadeType.MERGE ,mappedBy = "user",fetch = FetchType.EAGER,orphanRemoval = true)
    private List<UserAsset> assignedAssets;

    public User() {
    }

    public User(Integer userID) {
        this.userID = userID;
    }

    public User(Integer userID, String username, String password, String businessUnt, String comment, int roleID) {
        this.userID = userID;
        this.username = username;
      
        this.password = password;
        this.businessUnt = businessUnt;
        this.comment = comment;
  
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

 

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBusinessUnt() {
        return businessUnt;
    }

    public void setBusinessUnt(String businessUnt) {
        this.businessUnt = businessUnt;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public List<UserAsset> getAssignedAssets() {
        return assignedAssets;
    }

    public void setAssignedAssets(List<UserAsset> assignedAssets) {
        this.assignedAssets = assignedAssets;
    }

    @Override
    public String toString() {
        return "User{" +
            "userID=" + userID +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            ", businessUnt='" + businessUnt + '\'' +
            ", comment='" + comment + '\'' +
            ", userRole=" + userRole +
            ", assignedAssets=" + assignedAssets +
            '}';
    }
}
