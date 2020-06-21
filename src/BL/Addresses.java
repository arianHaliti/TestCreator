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
@Table(name = "Addresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Addresses.findAll", query = "SELECT a FROM Addresses a")
    , @NamedQuery(name = "Addresses.findByAddressID", query = "SELECT a FROM Addresses a WHERE a.addressID = :addressID")
    , @NamedQuery(name = "Addresses.findByStreetName", query = "SELECT a FROM Addresses a WHERE a.streetName = :streetName")})
public class Addresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "AddressID")
    private Integer addressID;
    @Basic(optional = false)
    @Column(name = "StreetName")
    private String streetName;
    @JoinColumn(name = "City_ID", referencedColumnName = "City_ID")
    @ManyToOne(optional = false)
    private Cities cityID;
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID")
    @ManyToOne(optional = false)
    private Students studentID;

    public Addresses() {
    }

    public Addresses(Integer addressID) {
        this.addressID = addressID;
    }

    public Addresses(Integer addressID, String streetName) {
        this.addressID = addressID;
        this.streetName = streetName;
    }

    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Cities getCityID() {
        return cityID;
    }

    public void setCityID(Cities cityID) {
        this.cityID = cityID;
    }

    public Students getStudentID() {
        return studentID;
    }

    public void setStudentID(Students studentID) {
        this.studentID = studentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressID != null ? addressID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Addresses)) {
            return false;
        }
        Addresses other = (Addresses) object;
        if ((this.addressID == null && other.addressID != null) || (this.addressID != null && !this.addressID.equals(other.addressID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Addresses[ addressID=" + addressID + " ]";
    }
    
}
