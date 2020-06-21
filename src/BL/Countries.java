/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arian
 */
@Entity
@Table(name = "Countries")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countries.findAll", query = "SELECT c FROM Countries c")
    , @NamedQuery(name = "Countries.findByCountryID", query = "SELECT c FROM Countries c WHERE c.countryID = :countryID")
    , @NamedQuery(name = "Countries.findByCountryname", query = "SELECT c FROM Countries c WHERE c.countryname = :countryname")})
public class Countries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "Country_ID")
    private Integer countryID;
    @Basic(optional = false)
    @Column(name = "Country_name")
    private String countryname;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "countryID")
    private Collection<Cities> citiesCollection;

    public Countries() {
    }

    public Countries(Integer countryID) {
        this.countryID = countryID;
    }

    public Countries(Integer countryID, String countryname) {
        this.countryID = countryID;
        this.countryname = countryname;
    }

    public Integer getCountryID() {
        return countryID;
    }

    public void setCountryID(Integer countryID) {
        this.countryID = countryID;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    @XmlTransient
    public Collection<Cities> getCitiesCollection() {
        return citiesCollection;
    }

    public void setCitiesCollection(Collection<Cities> citiesCollection) {
        this.citiesCollection = citiesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryID != null ? countryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Countries)) {
            return false;
        }
        Countries other = (Countries) object;
        if ((this.countryID == null && other.countryID != null) || (this.countryID != null && !this.countryID.equals(other.countryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Countries[ countryID=" + countryID + " ]";
    }
    
}
