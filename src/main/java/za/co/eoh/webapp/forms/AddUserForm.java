/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.webapp.forms;

/**
 *
 * @author thakgatso
 */
public class AddUserForm {
   private int userID,roleID;
   private String username,type,password,businessUnt,comment,userRole_roleID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getUserRole_roleID() {
        return userRole_roleID;
    }

    public void setUserRole_roleID(String userRole_roleID) {
        this.userRole_roleID = userRole_roleID;
    }

    @Override
    public String toString() {
        return "AddUserForm{" + "userID=" + userID + ", username=" + username + ", type=" + type + ", password=" + password + ", businessUnt=" + businessUnt + ", comment=" + comment + ", roleID=" + roleID + ", userRole_roleID=" + userRole_roleID + '}';
    }

}
