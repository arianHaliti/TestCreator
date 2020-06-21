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
@Table(name = "Student_Answer_Test")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentAnswerTest.findAll", query = "SELECT s FROM StudentAnswerTest s")
    , @NamedQuery(name = "StudentAnswerTest.findByStudentATID", query = "SELECT s FROM StudentAnswerTest s WHERE s.studentATID = :studentATID")})
public class StudentAnswerTest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "Student_AT_ID")
    private Integer studentATID;
    @JoinColumn(name = "AnswerID", referencedColumnName = "AnswerID")
    @ManyToOne(optional = false)
    private Answers answerID;
    @JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID")
    @ManyToOne(optional = false)
    private Questions questionID;
    @JoinColumn(name = "Answer_S_ID", referencedColumnName = "Answer_S_ID")
    @ManyToOne(optional = false)
    private StudentAnswers answerSID;
    @JoinColumn(name = "Test_StudentID", referencedColumnName = "Test_StudentID")
    @ManyToOne(optional = false)
    private StudentTest testStudentID;

    public StudentAnswerTest() {
    }

    public StudentAnswerTest(Integer studentATID) {
        this.studentATID = studentATID;
    }

    public Integer getStudentATID() {
        return studentATID;
    }

    public void setStudentATID(Integer studentATID) {
        this.studentATID = studentATID;
    }

    public Answers getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Answers answerID) {
        this.answerID = answerID;
    }

    public Questions getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Questions questionID) {
        this.questionID = questionID;
    }

    public StudentAnswers getAnswerSID() {
        return answerSID;
    }

    public void setAnswerSID(StudentAnswers answerSID) {
        this.answerSID = answerSID;
    }

    public StudentTest getTestStudentID() {
        return testStudentID;
    }

    public void setTestStudentID(StudentTest testStudentID) {
        this.testStudentID = testStudentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentATID != null ? studentATID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentAnswerTest)) {
            return false;
        }
        StudentAnswerTest other = (StudentAnswerTest) object;
        if ((this.studentATID == null && other.studentATID != null) || (this.studentATID != null && !this.studentATID.equals(other.studentATID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.StudentAnswerTest[ studentATID=" + studentATID + " ]";
    }
    
}
