/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.myapp.pojo.Subject;
import com.myapp.pojo.User;
import com.myapp.repositories.SubjectRepository;
import com.myapp.repositories.UserRepository;
import com.myapp.services.SubjectService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Subject> getSubjects(Map<String, String> params) {
        return this.subRepo.getSubjects(params);
    }

    @Override
    public Subject getSubjectById(int id) {
        return this.subRepo.getSubjectById(id);
    }

    @Override
    public Subject addOrUpdateSubject(Subject s) {
        // Nếu có file ảnh, upload lên Cloudinary
        if (!s.getFile().isEmpty()) {
            try {
                Map res = cloudinary.uploader().upload(s.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                s.setImageUrl(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(SubjectServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.subRepo.addOrUpdateSubject(s);
    }

    @Override
    public boolean hasRole(String email, String role) {
        User u = userRepo.getUserByEmail(email);
        return u != null && u.getRole().equals(role);
    }

    @Override
    public void deleleSubject(int id) {
        this.subRepo.deleleSubject(id);
    }

}
