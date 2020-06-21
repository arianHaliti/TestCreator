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
@Table(name = "Subjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subjects.findAll", query = "SELECT s FROM Subjects s")
    , @NamedQuery(name = "Subjects.findBySubjectID", query = "SELECT s FROM Subjects s WHERE s.subjectID = :subjectID")
    , @NamedQuery(name = "Subjects.findBySubjectName", query = "SELECT s FROM Subjects s WHERE s.subjectName = :subjectName")
    , @NamedQuery(name = "Subjects.findByCredits", query = "SELECT s FROM Subjects s WHERE s.credits = :credits")})
public class Subjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "SubjectID")
    private Integer subjectID;
    @Basic(optional = false)
    @Column(name = "SubjectName")
    private String subjectName;
    @Basic(optional = false)
    @Column(name = "Credits")
    private int credits;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "subjectID")
    private Collection<ProfesorSubjects> profesorSubjectsCollection;

    public Subjects() {
    }

    public Subjects(Integer subjectID) {
        this.subjectID = subjectID;
    }

    public Subjects(Integer subjectID, String subjectName, int credits) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.credits = credits;
    }

    public Integer getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Integer subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
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
        hash += (subjectID != null ? subjectID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subjects)) {
            return false;
        }
        Subjects other = (Subjects) object;
        if ((this.subjectID == null && other.subjectID != null) || (this.subjectID != null && !this.subjectID.equals(other.subjectID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Subjects[ subjectID=" + subjectID + " ]";
    }
    
}
