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
@Table(name = "Student_Test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentTest.findAll", query = "SELECT s FROM StudentTest s")
    , @NamedQuery(name = "StudentTest.findByTestStudentID", query = "SELECT s FROM StudentTest s WHERE s.testStudentID = :testStudentID")
    , @NamedQuery(name = "StudentTest.findByNrPikeve", query = "SELECT s FROM StudentTest s WHERE s.nrPikeve = :nrPikeve")
    , @NamedQuery(name = "StudentTest.findByTestDone", query = "SELECT s FROM StudentTest s WHERE s.testDone = :testDone")})
public class StudentTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
@GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "Test_StudentID")
    private Integer testStudentID;
    @Basic(optional = false)
    @Column(name = "nrPikeve")
    private int nrPikeve;
    @Basic(optional = false)
    @Column(name = "testDone")
    private boolean testDone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testStudentID")
    private Collection<StudentAnswerTest> studentAnswerTestCollection;
    @JoinColumn(name = "StudentID", referencedColumnName = "StudentID")
    @ManyToOne(optional = false)
    private Students studentID;
    @JoinColumn(name = "TestID", referencedColumnName = "TestID")
    @ManyToOne(optional = false)
    private Test testID;

    public StudentTest() {
    }

    public StudentTest(Integer testStudentID) {
        this.testStudentID = testStudentID;
    }

    public StudentTest(Integer testStudentID, int nrPikeve, boolean testDone) {
        this.testStudentID = testStudentID;
        this.nrPikeve = nrPikeve;
        this.testDone = testDone;
    }

    public Integer getTestStudentID() {
        return testStudentID;
    }

    public void setTestStudentID(Integer testStudentID) {
        this.testStudentID = testStudentID;
    }

    public int getNrPikeve() {
        return nrPikeve;
    }

    public void setNrPikeve(int nrPikeve) {
        this.nrPikeve = nrPikeve;
    }

    public boolean getTestDone() {
        return testDone;
    }

    public void setTestDone(boolean testDone) {
        this.testDone = testDone;
    }

    @XmlTransient
    public Collection<StudentAnswerTest> getStudentAnswerTestCollection() {
        return studentAnswerTestCollection;
    }

    public void setStudentAnswerTestCollection(Collection<StudentAnswerTest> studentAnswerTestCollection) {
        this.studentAnswerTestCollection = studentAnswerTestCollection;
    }

    public Students getStudentID() {
        return studentID;
    }

    public void setStudentID(Students studentID) {
        this.studentID = studentID;
    }

    public Test getTestID() {
        return testID;
    }

    public void setTestID(Test testID) {
        this.testID = testID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testStudentID != null ? testStudentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentTest)) {
            return false;
        }
        StudentTest other = (StudentTest) object;
        if ((this.testStudentID == null && other.testStudentID != null) || (this.testStudentID != null && !this.testStudentID.equals(other.testStudentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.StudentTest[ testStudentID=" + testStudentID + " ]";
    }
    
}
