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
@Table(name = "class_subject")
public class ClassSubject implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class classId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subjectId;
    
    @OneToMany(mappedBy = "classSubjectId", cascade = CascadeType.ALL)
    private Set<Score> scores;

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
     * @return the classId
     */
    public Class getClassId() {
        return classId;
    }

    /**
     * @param classId the classId to set
     */
    public void setClassId(Class classId) {
        this.classId = classId;
    }

    /**
     * @return the subjectId
     */
    public Subject getSubjectId() {
        return subjectId;
    }

    /**
     * @param subjectId the subjectId to set
     */
    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
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
        ClassSubject other = (ClassSubject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myapp.pojo.ClassSubject[ id=" + id + " ]";
    }

    /**
     * @return the scores
     */
    public Set<Score> getScores() {
        return scores;
    }

    /**
     * @param scores the scores to set
     */
    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }
}
