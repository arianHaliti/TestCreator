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
@Table(name = "Programs_Subjects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramsSubjects.findAll", query = "SELECT p FROM ProgramsSubjects p")
    , @NamedQuery(name = "ProgramsSubjects.findByProgramSubjectID", query = "SELECT p FROM ProgramsSubjects p WHERE p.programSubjectID = :programSubjectID")})
public class ProgramsSubjects implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
@GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "Program_SubjectID")
    private Integer programSubjectID;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "programSubjectID")
    private Collection<Test> testCollection;
    @JoinColumn(name = "Profesor_SubjectID", referencedColumnName = "Profesor_SubjectID")
    @ManyToOne(optional = false)
    private ProfesorSubjects profesorSubjectID;
    @JoinColumn(name = "ProgramID", referencedColumnName = "ProgramsID")
    @ManyToOne(optional = false)
    private Programs programID;

    public ProgramsSubjects() {
    }

    public ProgramsSubjects(Integer programSubjectID) {
        this.programSubjectID = programSubjectID;
    }

    public Integer getProgramSubjectID() {
        return programSubjectID;
    }

    public void setProgramSubjectID(Integer programSubjectID) {
        this.programSubjectID = programSubjectID;
    }

    @XmlTransient
    public Collection<Test> getTestCollection() {
        return testCollection;
    }

    public void setTestCollection(Collection<Test> testCollection) {
        this.testCollection = testCollection;
    }

    public ProfesorSubjects getProfesorSubjectID() {
        return profesorSubjectID;
    }

    public void setProfesorSubjectID(ProfesorSubjects profesorSubjectID) {
        this.profesorSubjectID = profesorSubjectID;
    }

    public Programs getProgramID() {
        return programID;
    }

    public void setProgramID(Programs programID) {
        this.programID = programID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programSubjectID != null ? programSubjectID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramsSubjects)) {
            return false;
        }
        ProgramsSubjects other = (ProgramsSubjects) object;
        if ((this.programSubjectID == null && other.programSubjectID != null) || (this.programSubjectID != null && !this.programSubjectID.equals(other.programSubjectID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.ProgramsSubjects[ programSubjectID=" + programSubjectID + " ]";
    }
    
}
