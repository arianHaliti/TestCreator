/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author arian
 */
@Entity
@Table(name = "Students")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Students.findAll", query = "SELECT s FROM Students s")
    , @NamedQuery(name = "Students.findByStudentID", query = "SELECT s FROM Students s WHERE s.studentID = :studentID")
    , @NamedQuery(name = "Students.findByParentName", query = "SELECT s FROM Students s WHERE s.parentName = :parentName")
    , @NamedQuery(name = "Students.findByDateOfBirth", query = "SELECT s FROM Students s WHERE s.dateOfBirth = :dateOfBirth")
    , @NamedQuery(name = "Students.findByGender", query = "SELECT s FROM Students s WHERE s.gender = :gender")
    , @NamedQuery(name = "Students.findByPersonalNumber", query = "SELECT s FROM Students s WHERE s.personalNumber = :personalNumber")
    , @NamedQuery(name = "Students.findByInTestStatus", query = "SELECT s FROM Students s WHERE s.inTestStatus = :inTestStatus")})
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    
    @GeneratedValue(generator="InvSeq")
 @SequenceGenerator(name="InvSeq",sequenceName="INV_SEQ", allocationSize=1)
 
    @Basic(optional = false)
    @Column(name = "StudentID")
    private Integer studentID;
    @Column(name = "ParentName")
    private String parentName;
    @Basic(optional = false)
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "Gender")
    private Character gender;
    @Basic(optional = false)
    @Column(name = "PersonalNumber")
    private String personalNumber;
    @Basic(optional = false)
    @Column(name = "inTestStatus")
    private boolean inTestStatus;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "studentID")
    private Collection<StudentTest> studentTestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentID")
    private Collection<Addresses> addressesCollection;
    @JoinColumn(name = "ProgramID", referencedColumnName = "ProgramsID")
    @ManyToOne(optional = false)
    private Programs programID;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
    @ManyToOne(optional = false)
    private Users userID;

    public Students() {
    }

    public Students(Integer studentID) {
        this.studentID = studentID;
    }

    public Students(Integer studentID, Date dateOfBirth, Character gender, String personalNumber, boolean inTestStatus) {
        this.studentID = studentID;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.personalNumber = personalNumber;
        this.inTestStatus = inTestStatus;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public boolean getInTestStatus() {
        return inTestStatus;
    }

    public void setInTestStatus(boolean inTestStatus) {
        this.inTestStatus = inTestStatus;
    }

    @XmlTransient
    public Collection<StudentTest> getStudentTestCollection() {
        return studentTestCollection;
    }

    public void setStudentTestCollection(Collection<StudentTest> studentTestCollection) {
        this.studentTestCollection = studentTestCollection;
    }

    @XmlTransient
    public Collection<Addresses> getAddressesCollection() {
        return addressesCollection;
    }

    public void setAddressesCollection(Collection<Addresses> addressesCollection) {
        this.addressesCollection = addressesCollection;
    }

    public Programs getProgramID() {
        return programID;
    }

    public void setProgramID(Programs programID) {
        this.programID = programID;
    }

    public Users getUserID() {
        return userID;
    }

    public void setUserID(Users userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentID != null ? studentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.studentID == null && other.studentID != null) || (this.studentID != null && !this.studentID.equals(other.studentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Students[ studentID=" + studentID + " ]";
    }
    
}
