/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.pojo;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "subject")
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findById", query = "SELECT s FROM Subject s WHERE s.id = :id"),
    @NamedQuery(name = "Subject.findBySubjectCode", query = "SELECT s FROM Subject s WHERE s.subjectCode = :subjectCode")
})
public class Subject implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "subject_code")
    private String subjectCode;
    
    @Basic(optional = false)
    @Column(name = "subject_name")
    private String subjectName;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "credits")
    private Integer credits;

    @OneToMany(mappedBy = "subjectId", cascade = CascadeType.ALL)
    private Set<ClassSubject> classSubjects;
    

    // Constructors
    public Subject() {}

    public Subject(Integer id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the subjectCode
     */
    public String getSubjectCode() {
        return subjectCode;
    }

    /**
     * @param subjectCode the subjectCode to set
     */
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    /**
     * @return the subjectName
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * @param subjectName the subjectName to set
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the credits
     */
    public Integer getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    /**
     * @return the classSubjects
     */
    public Set<ClassSubject> getClassSubjects() {
        return classSubjects;
    }

    /**
     * @param classSubjects the classSubjects to set
     */
    public void setClassSubjects(Set<ClassSubject> classSubjects) {
        this.classSubjects = classSubjects;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Class)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myapp.pojo.Subject[ id=" + id + " ]";
    }
}
