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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Profesor_Subjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProfesorSubjects.findAll", query = "SELECT p FROM ProfesorSubjects p")
    , @NamedQuery(name = "ProfesorSubjects.findByProfesorSubjectID", query = "SELECT p FROM ProfesorSubjects p WHERE p.profesorSubjectID = :profesorSubjectID")})
public class ProfesorSubjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
@GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "Profesor_SubjectID")
    private Integer profesorSubjectID;
    @JoinColumn(name = "ProfesorID", referencedColumnName = "ProfesorID")
    @ManyToOne(optional = false)
    private Profesors profesorID;
    @JoinColumn(name = "SubjectID", referencedColumnName = "SubjectID")
    @ManyToOne(optional = false)
    private Subjects subjectID;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "profesorSubjectID")
    private Collection<ProgramsSubjects> programsSubjectsCollection;

    public ProfesorSubjects() {
    }

    public ProfesorSubjects(Integer profesorSubjectID) {
        this.profesorSubjectID = profesorSubjectID;
    }

    public Integer getProfesorSubjectID() {
        return profesorSubjectID;
    }

    public void setProfesorSubjectID(Integer profesorSubjectID) {
        this.profesorSubjectID = profesorSubjectID;
    }

    public Profesors getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(Profesors profesorID) {
        this.profesorID = profesorID;
    }

    public Subjects getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(Subjects subjectID) {
        this.subjectID = subjectID;
    }

    @XmlTransient
    public Collection<ProgramsSubjects> getProgramsSubjectsCollection() {
        return programsSubjectsCollection;
    }

    public void setProgramsSubjectsCollection(Collection<ProgramsSubjects> programsSubjectsCollection) {
        this.programsSubjectsCollection = programsSubjectsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profesorSubjectID != null ? profesorSubjectID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfesorSubjects)) {
            return false;
        }
        ProfesorSubjects other = (ProfesorSubjects) object;
        if ((this.profesorSubjectID == null && other.profesorSubjectID != null) || (this.profesorSubjectID != null && !this.profesorSubjectID.equals(other.profesorSubjectID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.ProfesorSubjects[ profesorSubjectID=" + profesorSubjectID + " ]";
    }
    
}
