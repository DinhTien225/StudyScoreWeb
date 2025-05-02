/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.pojo;

import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;
/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;

    @Basic(optional = false)
    @Column(name="email")
    private String email;

    @Basic(optional = false)
    @Column(name="password")
    private String password;

    @Basic(optional = false)
    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "student_code")
    private String studentCode;

    @Column(name = "lecturer_code")
    private String lecturerCode;

    @ManyToOne
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class classId;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "active")
    private Boolean active;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<ForumPost> forumPosts;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private Set<ForumComment> forumComments;

    @OneToMany(mappedBy = "updatedBy", cascade = CascadeType.ALL)
    private Set<Score> updatedScores;

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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return the avatarUrl
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * @param avatarUrl the avatarUrl to set
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * @return the studentCode
     */
    public String getStudentCode() {
        return studentCode;
    }

    /**
     * @param studentCode the studentCode to set
     */
    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    /**
     * @return the lecturerCode
     */
    public String getLecturerCode() {
        return lecturerCode;
    }

    /**
     * @param lecturerCode the lecturerCode to set
     */
    public void setLecturerCode(String lecturerCode) {
        this.lecturerCode = lecturerCode;
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
     * @return the createdAt
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
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

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the forumPosts
     */
    public Set<ForumPost> getForumPosts() {
        return forumPosts;
    }

    /**
     * @param forumPosts the forumPosts to set
     */
    public void setForumPosts(Set<ForumPost> forumPosts) {
        this.forumPosts = forumPosts;
    }

    /**
     * @return the forumComments
     */
    public Set<ForumComment> getForumComments() {
        return forumComments;
    }

    /**
     * @param forumComments the forumComments to set
     */
    public void setForumComments(Set<ForumComment> forumComments) {
        this.forumComments = forumComments;
    }

    /**
     * @return the updatedScores
     */
    public Set<Score> getUpdatedScores() {
        return updatedScores;
    }

    /**
     * @param updatedScores the updatedScores to set
     */
    public void setUpdatedScores(Set<Score> updatedScores) {
        this.updatedScores = updatedScores;
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
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myapp.pojo.User[ id=" + id + " ]";
    }
}
