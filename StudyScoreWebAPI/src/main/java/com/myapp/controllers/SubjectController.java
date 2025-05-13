/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.controllers;

import com.myapp.pojo.Subject;
import com.myapp.services.SubjectService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ADMIN
 */
@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    
    @GetMapping("/subjects")
    public String subjectPage(Model model,Map<String, String> params) {
        model.addAttribute("subject", new Subject()); 
        model.addAttribute("subjects", subjectService.getSubjects(params)); 
        return "subject"; 
    }
    
    @PostMapping("/subjects/add")
    public String add(@ModelAttribute(value = "subject") Subject s) {
        this.subjectService.addOrUpdateSubject(s);
        
        return "redirect:/";
    }
}
