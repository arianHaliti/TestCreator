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
@Table(name = "Questions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questions.findAll", query = "SELECT q FROM Questions q")
    , @NamedQuery(name = "Questions.findByQuestionID", query = "SELECT q FROM Questions q WHERE q.questionID = :questionID")
    , @NamedQuery(name = "Questions.findByPointNr", query = "SELECT q FROM Questions q WHERE q.pointNr = :pointNr")
    , @NamedQuery(name = "Questions.findByQuestionType", query = "SELECT q FROM Questions q WHERE q.questionType = :questionType")
    , @NamedQuery(name = "Questions.findByOptionnr", query = "SELECT q FROM Questions q WHERE q.optionnr = :optionnr")
    , @NamedQuery(name = "Questions.findByQuestionDesc", query = "SELECT q FROM Questions q WHERE q.questionDesc = :questionDesc")})
public class Questions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
@GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "QuestionID")
    private Integer questionID;
    @Basic(optional = false)
    @Column(name = "PointNr")
    private int pointNr;
    @Basic(optional = false)
    @Column(name = "Question_Type")
    private int questionType;
    @Basic(optional = false)
    @Column(name = "Option_nr")
    private int optionnr;
    @Basic(optional = false)
    @Column(name = "Question_Desc")
    private String questionDesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionFK")
    private Collection<Answers> answersCollection;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "questionID")
    private Collection<StudentAnswerTest> studentAnswerTestCollection;
    @JoinColumn(name = "Test_FK", referencedColumnName = "TestID")
    @ManyToOne(optional = false)
    private Test testFK;

    public Questions() {
    }

    public Questions(Integer questionID) {
        this.questionID = questionID;
    }

    public Questions(Integer questionID, int pointNr, int questionType, int optionnr, String questionDesc) {
        this.questionID = questionID;
        this.pointNr = pointNr;
        this.questionType = questionType;
        this.optionnr = optionnr;
        this.questionDesc = questionDesc;
    }

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }

    public int getPointNr() {
        return pointNr;
    }

    public void setPointNr(int pointNr) {
        this.pointNr = pointNr;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public int getOptionnr() {
        return optionnr;
    }

    public void setOptionnr(int optionnr) {
        this.optionnr = optionnr;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    @XmlTransient
    public Collection<Answers> getAnswersCollection() {
        return answersCollection;
    }

    public void setAnswersCollection(Collection<Answers> answersCollection) {
        this.answersCollection = answersCollection;
    }

    @XmlTransient
    public Collection<StudentAnswerTest> getStudentAnswerTestCollection() {
        return studentAnswerTestCollection;
    }

    public void setStudentAnswerTestCollection(Collection<StudentAnswerTest> studentAnswerTestCollection) {
        this.studentAnswerTestCollection = studentAnswerTestCollection;
    }

    public Test getTestFK() {
        return testFK;
    }

    public void setTestFK(Test testFK) {
        this.testFK = testFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionID != null ? questionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.questionID == null && other.questionID != null) || (this.questionID != null && !this.questionID.equals(other.questionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Questions[ questionID=" + questionID + " ]";
    }
    
}
