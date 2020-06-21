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
@Table(name = "Test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t")
    , @NamedQuery(name = "Test.findByTestID", query = "SELECT t FROM Test t WHERE t.testID = :testID")
    , @NamedQuery(name = "Test.findByTestActive", query = "SELECT t FROM Test t WHERE t.testActive = :testActive")
    , @NamedQuery(name = "Test.findByTestName", query = "SELECT t FROM Test t WHERE t.testName = :testName")
    , @NamedQuery(name = "Test.findByNrQuestions", query = "SELECT t FROM Test t WHERE t.nrQuestions = :nrQuestions")
    , @NamedQuery(name = "Test.findByPoints", query = "SELECT t FROM Test t WHERE t.points = :points")
    , @NamedQuery(name = "Test.findByDescriptions", query = "SELECT t FROM Test t WHERE t.descriptions = :descriptions")
    , @NamedQuery(name = "Test.findByDuration", query = "SELECT t FROM Test t WHERE t.duration = :duration")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(generator="InvSeq")
    @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "TestID")
    private Integer testID;
    @Basic(optional = false)
    @Column(name = "TestActive")
    private boolean testActive;
    @Basic(optional = false)
    @Column(name = "TestName")
    private String testName;
    @Basic(optional = false)
    @Column(name = "nrQuestions")
    private int nrQuestions;
    @Basic(optional = false)
    @Column(name = "Points")
    private int points;
    @Column(name = "Descriptions")
    private String descriptions;
    @Basic(optional = false)
    @Column(name = "Duration")
    private int duration;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "testID")
    private Collection<StudentTest> studentTestCollection;
    @JoinColumn(name = "Program_SubjectID", referencedColumnName = "Program_SubjectID")
    @ManyToOne(optional = false)
    private ProgramsSubjects programSubjectID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testFK")
    private Collection<Questions> questionsCollection;

    public Test() {
    }

    public Test(Integer testID) {
        this.testID = testID;
    }

    public Test(Integer testID, boolean testActive, String testName, int nrQuestions, int points, int duration) {
        this.testID = testID;
        this.testActive = testActive;
        this.testName = testName;
        this.nrQuestions = nrQuestions;
        this.points = points;
        this.duration = duration;
    }

    public Integer getTestID() {
        return testID;
    }

    public void setTestID(Integer testID) {
        this.testID = testID;
    }

    public boolean getTestActive() {
        return testActive;
    }

    public void setTestActive(boolean testActive) {
        this.testActive = testActive;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getNrQuestions() {
        return nrQuestions;
    }

    public void setNrQuestions(int nrQuestions) {
        this.nrQuestions = nrQuestions;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @XmlTransient
    public Collection<StudentTest> getStudentTestCollection() {
        return studentTestCollection;
    }

    public void setStudentTestCollection(Collection<StudentTest> studentTestCollection) {
        this.studentTestCollection = studentTestCollection;
    }

    public ProgramsSubjects getProgramSubjectID() {
        return programSubjectID;
    }

    public void setProgramSubjectID(ProgramsSubjects programSubjectID) {
        this.programSubjectID = programSubjectID;
    }

    @XmlTransient
    public Collection<Questions> getQuestionsCollection() {
        return questionsCollection;
    }

    public void setQuestionsCollection(Collection<Questions> questionsCollection) {
        this.questionsCollection = questionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testID != null ? testID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.testID == null && other.testID != null) || (this.testID != null && !this.testID.equals(other.testID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Test[ testID=" + testID + " ]";
    }
    
}
