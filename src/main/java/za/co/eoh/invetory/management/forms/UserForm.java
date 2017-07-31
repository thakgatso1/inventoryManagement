/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.invetory.management.forms;

import java.util.ArrayList;
import za.co.eoh.invetory.management.entity.Role;

import java.util.List;

/**
 *
 * @author thakgatso
 */
public class UserForm {
   private Integer userID,userRoleId;
   private String username,password,businessUnt,comment;
   private Role userRole;
   private List<Integer> userAssets=new ArrayList<>();

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

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

  public Role getUserRole() {
    return userRole;
  }

  public void setUserRole(Role userRole) {
    this.userRole = userRole;
  }

  public List<Integer> getUserAssets() {
    return userAssets;
  }

  public void setUserAssets(List<Integer> userAssets) {
    this.userAssets = userAssets;
  }

  @Override
  public String toString() {
    return "UserForm{" +
        "userID=" + userID +
        ", roleID=" + userRoleId+
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", businessUnt='" + businessUnt + '\'' +
        ", comment='" + comment + '\'' +
        ", userRoleId='" + userRoleId + '\'' +
        '}';
  }
}
