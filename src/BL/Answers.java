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
@Table(name = "Answers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answers.findAll", query = "SELECT a FROM Answers a")
    , @NamedQuery(name = "Answers.findByAnswerID", query = "SELECT a FROM Answers a WHERE a.answerID = :answerID")
    , @NamedQuery(name = "Answers.findByAnswercorrect", query = "SELECT a FROM Answers a WHERE a.answercorrect = :answercorrect")
    , @NamedQuery(name = "Answers.findByAnswerDesc", query = "SELECT a FROM Answers a WHERE a.answerDesc = :answerDesc")})
public class Answers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "AnswerID")
    private Integer answerID;
    @Basic(optional = false)
    @Column(name = "Answer_correct")
    private boolean answercorrect;
    @Basic(optional = false)
    @Column(name = "Answer_Desc")
    private String answerDesc;
    @JoinColumn(name = "Question_FK", referencedColumnName = "QuestionID")
    @ManyToOne(optional = false)
    private Questions questionFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answerID")
    private Collection<StudentAnswerTest> studentAnswerTestCollection;

    public Answers() {
    }

    public Answers(Integer answerID) {
        this.answerID = answerID;
    }

    public Answers(Integer answerID, boolean answercorrect, String answerDesc) {
        this.answerID = answerID;
        this.answercorrect = answercorrect;
        this.answerDesc = answerDesc;
    }

    public Integer getAnswerID() {
        return answerID;
    }

    public void setAnswerID(Integer answerID) {
        this.answerID = answerID;
    }

    public boolean getAnswercorrect() {
        return answercorrect;
    }

    public void setAnswercorrect(boolean answercorrect) {
        this.answercorrect = answercorrect;
    }

    public String getAnswerDesc() {
        return answerDesc;
    }

    public void setAnswerDesc(String answerDesc) {
        this.answerDesc = answerDesc;
    }

    public Questions getQuestionFK() {
        return questionFK;
    }

    public void setQuestionFK(Questions questionFK) {
        this.questionFK = questionFK;
    }

    @XmlTransient
    public Collection<StudentAnswerTest> getStudentAnswerTestCollection() {
        return studentAnswerTestCollection;
    }

    public void setStudentAnswerTestCollection(Collection<StudentAnswerTest> studentAnswerTestCollection) {
        this.studentAnswerTestCollection = studentAnswerTestCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (answerID != null ? answerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answers)) {
            return false;
        }
        Answers other = (Answers) object;
        if ((this.answerID == null && other.answerID != null) || (this.answerID != null && !this.answerID.equals(other.answerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Answers[ answerID=" + answerID + " ]";
    }
    
}
