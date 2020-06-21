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
@Table(name = "Emails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emails.findAll", query = "SELECT e FROM Emails e")
    , @NamedQuery(name = "Emails.findByEmailID", query = "SELECT e FROM Emails e WHERE e.emailID = :emailID")
    , @NamedQuery(name = "Emails.findByEmailAdress", query = "SELECT e FROM Emails e WHERE e.emailAdress = :emailAdress")})
public class Emails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "EmailID")
    private Integer emailID;
    @Basic(optional = false)
    @Column(name = "EmailAdress")
    private String emailAdress;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userID;

    public Emails() {
    }

    public Emails(Integer emailID) {
        this.emailID = emailID;
    }

    public Emails(Integer emailID, String emailAdress) {
        this.emailID = emailID;
        this.emailAdress = emailAdress;
    }

    public Integer getEmailID() {
        return emailID;
    }

    public void setEmailID(Integer emailID) {
        this.emailID = emailID;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
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
        hash += (emailID != null ? emailID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emails)) {
            return false;
        }
        Emails other = (Emails) object;
        if ((this.emailID == null && other.emailID != null) || (this.emailID != null && !this.emailID.equals(other.emailID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Emails[ emailID=" + emailID + " ]";
    }
    
}
