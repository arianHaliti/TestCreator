/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arian
 */
@Entity
@Table(name = "Profesors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesors.findAll", query = "SELECT p FROM Profesors p")
    , @NamedQuery(name = "Profesors.findByProfesorID", query = "SELECT p FROM Profesors p WHERE p.profesorID = :profesorID")
    , @NamedQuery(name = "Profesors.findByDateOfBirth", query = "SELECT p FROM Profesors p WHERE p.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Profesors.findByDegree", query = "SELECT p FROM Profesors p WHERE p.degree = :degree")})
public class Profesors implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
@GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "ProfesorID")
    private Integer profesorID;
    @Basic(optional = false)
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "Degree")
    private String degree;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userID;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "profesorID")
    private Collection<ProfesorSubjects> profesorSubjectsCollection;

    public Profesors() {
    }

    public Profesors(Integer profesorID) {
        this.profesorID = profesorID;
    }

    public Profesors(Integer profesorID, Date dateOfBirth) {
        this.profesorID = profesorID;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(Integer profesorID) {
        this.profesorID = profesorID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @XmlTransient
    public Collection<ProfesorSubjects> getProfesorSubjectsCollection() {
        return profesorSubjectsCollection;
    }

    public void setProfesorSubjectsCollection(Collection<ProfesorSubjects> profesorSubjectsCollection) {
        this.profesorSubjectsCollection = profesorSubjectsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesorID != null ? profesorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesors)) {
            return false;
        }
        Profesors other = (Profesors) object;
        if ((this.profesorID == null && other.profesorID != null) || (this.profesorID != null && !this.profesorID.equals(other.profesorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Profesors[ profesorID=" + profesorID + " ]";
    }
    
}
