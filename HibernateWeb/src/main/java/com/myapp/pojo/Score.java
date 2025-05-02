/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.pojo;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "score")
public class Score  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private User student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "class_subject_id", referencedColumnName = "id")
    private ClassSubject classSubjectId;

    @Column(name = "midterm_score")
    private Float midtermScore;

    @Column(name = "final_score")
    private Float finalScore;

    @Column(name = "extra_score1")
    private Float extraScore1;

    @Column(name = "extra_score2")
    private Float extraScore2;

    @Column(name = "extra_score3")
    private Float extraScore3;

    @Enumerated(EnumType.STRING)
    @Column(name = "lock_status")
    private LockStatus lockStatus;

    @ManyToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private User updatedBy;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

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
     * @return the student
     */
    public User getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(User student) {
        this.student = student;
    }

    

    /**
     * @return the midtermScore
     */
    public Float getMidtermScore() {
        return midtermScore;
    }

    /**
     * @param midtermScore the midtermScore to set
     */
    public void setMidtermScore(Float midtermScore) {
        this.midtermScore = midtermScore;
    }

    /**
     * @return the finalScore
     */
    public Float getFinalScore() {
        return finalScore;
    }

    /**
     * @param finalScore the finalScore to set
     */
    public void setFinalScore(Float finalScore) {
        this.finalScore = finalScore;
    }

    /**
     * @return the extraScore1
     */
    public Float getExtraScore1() {
        return extraScore1;
    }

    /**
     * @param extraScore1 the extraScore1 to set
     */
    public void setExtraScore1(Float extraScore1) {
        this.extraScore1 = extraScore1;
    }

    /**
     * @return the extraScore2
     */
    public Float getExtraScore2() {
        return extraScore2;
    }

    /**
     * @param extraScore2 the extraScore2 to set
     */
    public void setExtraScore2(Float extraScore2) {
        this.extraScore2 = extraScore2;
    }

    /**
     * @return the extraScore3
     */
    public Float getExtraScore3() {
        return extraScore3;
    }

    /**
     * @param extraScore3 the extraScore3 to set
     */
    public void setExtraScore3(Float extraScore3) {
        this.extraScore3 = extraScore3;
    }

    /**
     * @return the lockStatus
     */
    public LockStatus getLockStatus() {
        return lockStatus;
    }

    /**
     * @param lockStatus the lockStatus to set
     */
    public void setLockStatus(LockStatus lockStatus) {
        this.lockStatus = lockStatus;
    }

    /**
     * @return the updatedBy
     */
    public User getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy the updatedBy to set
     */
    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return the updatedAt
     */
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
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
        Score other = (Score) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myapp.pojo.Score[ id=" + id + " ]";
    }

    /**
     * @return the classSubjectId
     */
    public ClassSubject getClassSubjectId() {
        return classSubjectId;
    }

    /**
     * @param classSubjectId the classSubjectId to set
     */
    public void setClassSubjectId(ClassSubject classSubjectId) {
        this.classSubjectId = classSubjectId;
    }
}
