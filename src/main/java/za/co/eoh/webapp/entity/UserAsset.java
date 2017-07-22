/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.webapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thakgatso
 */
@Entity
@Table(name = "Assignment")
public class UserAsset implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "assignmentID")
    private Integer assignmentID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assignmentDate")
    @Temporal(TemporalType.DATE)
    private Date assignmentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unassignDate")
    @Temporal(TemporalType.DATE)
    private Date unassignDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "comment")
    private String comment;
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    @ManyToOne(optional = false)
    private User userID;
    @JoinColumn(name = "assetID", referencedColumnName = "assetID")
    @ManyToOne(optional = false)
    private Asset assetID;

    public UserAsset() {
    }

    public UserAsset(Integer assignmentID) {
        this.assignmentID = assignmentID;
    }

    public UserAsset(Integer assignmentID, Date assignmentDate, Date unassignDate, String comment) {
        this.assignmentID = assignmentID;
        this.assignmentDate = assignmentDate;
        this.unassignDate = unassignDate;
        this.comment = comment;
    }

    public Integer getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(Integer assignmentID) {
        this.assignmentID = assignmentID;
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

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Asset getAssetID() {
        return assetID;
    }

    public void setAssetID(Asset assetID) {
        this.assetID = assetID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assignmentID != null ? assignmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAsset)) {
            return false;
        }
        UserAsset other = (UserAsset) object;
        if ((this.assignmentID == null && other.assignmentID != null) || (this.assignmentID != null && !this.assignmentID.equals(other.assignmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.co.eoh.webapp.entity.Assignment[ assignmentID=" + assignmentID + " ]";
    }
    
}
