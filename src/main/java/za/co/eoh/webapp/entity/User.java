/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.webapp.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @Basic(optional = false)
    @Column(name = "userID")
    private Integer userID;
   
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "username")
    private String username;
    
//    
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "password")
    private String password;
   
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "businessUnt")
    private String businessUnt;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "comment")
    private String comment;
    
    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userRole_roleID",referencedColumnName = "roleID")
    private Role userRole;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userID")
    private List<UserAsset> assignmentList;

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
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.eoh.webapp.entity.User[ userID=" + userID + " ]";
    }
    
}
