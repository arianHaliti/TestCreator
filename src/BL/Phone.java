/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arian
 */
@Entity
@Table(name = "Phone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p")
    , @NamedQuery(name = "Phone.findByPhoneNumberID", query = "SELECT p FROM Phone p WHERE p.phoneNumberID = :phoneNumberID")
    , @NamedQuery(name = "Phone.findByPhoneNumber", query = "SELECT p FROM Phone p WHERE p.phoneNumber = :phoneNumber")})
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "PhoneNumberID")
    private Integer phoneNumberID;
    @Basic(optional = false)
    @Column(name = "PhoneNumber")
    private String phoneNumber;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userID;

    public Phone() {
    }

    public Phone(Integer phoneNumberID) {
        this.phoneNumberID = phoneNumberID;
    }

    public Phone(Integer phoneNumberID, String phoneNumber) {
        this.phoneNumberID = phoneNumberID;
        this.phoneNumber = phoneNumber;
    }

    public Integer getPhoneNumberID() {
        return phoneNumberID;
    }

    public void setPhoneNumberID(Integer phoneNumberID) {
        this.phoneNumberID = phoneNumberID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (phoneNumberID != null ? phoneNumberID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.phoneNumberID == null && other.phoneNumberID != null) || (this.phoneNumberID != null && !this.phoneNumberID.equals(other.phoneNumberID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Phone[ phoneNumberID=" + phoneNumberID + " ]";
    }
    
}
