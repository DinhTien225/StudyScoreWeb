/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.controllers;

import com.myapp.pojo.StudentClassSubject;
import com.myapp.services.StudentClassSubjectService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ADMIN
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiStuClassSubjectController {
    @Autowired
    private StudentClassSubjectService stuClassSubService;
     // api/stuClassSubjects/{id}
    @DeleteMapping("/stuClassSubjects/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable(value = "id") int id) {
        this.stuClassSubService.deleleStudentClassSubject(id);
    }
    
    @GetMapping("/stuClassSubjects")
    public ResponseEntity<List<StudentClassSubject>> listStudentClassSubjects(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.stuClassSubService.getStudentClassSubjects(params), HttpStatus.OK);
    }
    
 
    @GetMapping("/stuClassSubjects/{id}")
    public ResponseEntity<StudentClassSubject> retrieve(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(this.stuClassSubService.getStudentClassSubjectById(id), HttpStatus.OK);
    }
    
    @GetMapping("/stuClassSubjects/student/{studentId}")
    public ResponseEntity<List<StudentClassSubject>> listClassSubjectsByLecturerId(@PathVariable(value = "studentId") int studentId){
        return new ResponseEntity<>(this.stuClassSubService.getStudentClassSubjectsByStudentId(studentId), HttpStatus.OK);
    }
}
