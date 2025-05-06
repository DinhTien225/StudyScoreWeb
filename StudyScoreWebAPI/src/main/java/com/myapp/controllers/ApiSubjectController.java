/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.controllers;

import com.myapp.pojo.Score;
import com.myapp.pojo.Subject;
import com.myapp.services.SubjectService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiSubjectController {
    @Autowired
    private SubjectService subService;

    // api/subjects – Danh sách môn học (ai cũng xem được)
    @GetMapping("/subjects")
    public ResponseEntity<List<Subject>> listSubjects(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(subService.getSubjects(params), HttpStatus.OK);
    }

    // api/subjects/add – Tạo môn học (chỉ giáo vụ)
    @PostMapping("/subjects/add")
    public ResponseEntity<?> createSubject(@RequestBody Subject subject, Principal user) {
        if (!subService.hasRole(user.getName(), "ROLE_GIAOVU")) {
            return new ResponseEntity<>("Bạn không có quyền tạo môn học!", HttpStatus.FORBIDDEN);
        }

        Subject created = subService.addOrUpdateSubject(subject);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // api/subjects/{id} – Sửa môn học (chỉ giáo vụ)
    @PutMapping("/subjects/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable("id") int id,
                                           @RequestBody Subject subject,
                                           Principal user) {
        if (!subService.hasRole(user.getName(), "ROLE_GIAOVU")) {
            return new ResponseEntity<>("Bạn không có quyền sửa môn học!", HttpStatus.FORBIDDEN);
        }

        subject.setId(id);
        Subject updated = subService.addOrUpdateSubject(subject);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
    
}
