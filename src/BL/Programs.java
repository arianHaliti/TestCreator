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
@Table(name = "Programs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Programs.findAll", query = "SELECT p FROM Programs p")
    , @NamedQuery(name = "Programs.findByProgramsID", query = "SELECT p FROM Programs p WHERE p.programsID = :programsID")
    , @NamedQuery(name = "Programs.findByProgramName", query = "SELECT p FROM Programs p WHERE p.programName = :programName")
    , @NamedQuery(name = "Programs.findByMaster", query = "SELECT p FROM Programs p WHERE p.master = :master")})
public class Programs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "ProgramsID")
    private Integer programsID;
    @Basic(optional = false)
    @Column(name = "ProgramName")
    private String programName;
    @Basic(optional = false)
    @Column(name = "Master")
    private boolean master;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "programID")
    private Collection<Students> studentsCollection;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "programID")
    private Collection<ProgramsSubjects> programsSubjectsCollection;

    public Programs() {
    }

    public Programs(Integer programsID) {
        this.programsID = programsID;
    }

    public Programs(Integer programsID, String programName, boolean master) {
        this.programsID = programsID;
        this.programName = programName;
        this.master = master;
    }

    public Integer getProgramsID() {
        return programsID;
    }

    public void setProgramsID(Integer programsID) {
        this.programsID = programsID;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public boolean getMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    @XmlTransient
    public Collection<Students> getStudentsCollection() {
        return studentsCollection;
    }

    public void setStudentsCollection(Collection<Students> studentsCollection) {
        this.studentsCollection = studentsCollection;
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
        hash += (programsID != null ? programsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Programs)) {
            return false;
        }
        Programs other = (Programs) object;
        if ((this.programsID == null && other.programsID != null) || (this.programsID != null && !this.programsID.equals(other.programsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Programs[ programsID=" + programsID + " ]";
    }
    
}
