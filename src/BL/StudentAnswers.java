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
@Table(name = "Student_Answers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentAnswers.findAll", query = "SELECT s FROM StudentAnswers s")
    , @NamedQuery(name = "StudentAnswers.findByAnswerSID", query = "SELECT s FROM StudentAnswers s WHERE s.answerSID = :answerSID")
    , @NamedQuery(name = "StudentAnswers.findByAnswerTicked", query = "SELECT s FROM StudentAnswers s WHERE s.answerTicked = :answerTicked")})
public class StudentAnswers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "Answer_S_ID")
    private Integer answerSID;
    @Basic(optional = false)
    @Column(name = "Answer_Ticked")
    private boolean answerTicked;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "answerSID")
    private Collection<StudentAnswerTest> studentAnswerTestCollection;

    public StudentAnswers() {
    }

    public StudentAnswers(Integer answerSID) {
        this.answerSID = answerSID;
    }

    public StudentAnswers(Integer answerSID, boolean answerTicked) {
        this.answerSID = answerSID;
        this.answerTicked = answerTicked;
    }

    public Integer getAnswerSID() {
        return answerSID;
    }

    public void setAnswerSID(Integer answerSID) {
        this.answerSID = answerSID;
    }

    public boolean getAnswerTicked() {
        return answerTicked;
    }

    public void setAnswerTicked(boolean answerTicked) {
        this.answerTicked = answerTicked;
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
        hash += (answerSID != null ? answerSID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentAnswers)) {
            return false;
        }
        StudentAnswers other = (StudentAnswers) object;
        if ((this.answerSID == null && other.answerSID != null) || (this.answerSID != null && !this.answerSID.equals(other.answerSID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.StudentAnswers[ answerSID=" + answerSID + " ]";
    }
    
}
