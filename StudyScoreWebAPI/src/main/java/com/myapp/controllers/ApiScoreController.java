/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.controllers;

import com.myapp.pojo.Score;
import com.myapp.services.ScoreService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
public class ApiScoreController {

    @Autowired
    private ScoreService scoreService;

    // api/scores/{id}
    @DeleteMapping("/scores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void destroy(@PathVariable(value = "id") int id) {
        this.scoreService.deleleScore(id);
    }

    // api/scores – Danh sách môn học 
    @GetMapping("/scores")
    public ResponseEntity<List<Score>> listScores(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(scoreService.getScores(params), HttpStatus.OK);
    }

    // api/scores/{id} – Chi tiết 
    @GetMapping("/scores/{id}")
    public ResponseEntity<Score> retrieve(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(scoreService.getScoreById(id), HttpStatus.OK);
    }

    @PutMapping("/scores/lock/{classSubjectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void lockScores(@PathVariable(value = "classSubjectId") int classSubjectId) {
        this.scoreService.lockScoresByClassSubjectId(classSubjectId);
    }

    @PostMapping("/scores/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateScore(@PathVariable("id") int id, @RequestBody Score sc) {
        sc.setId(id);
        this.scoreService.addOrUpdateScore(sc);
    }

    @PostMapping("/scores/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addScore(@RequestBody Score sc) {
        this.scoreService.addOrUpdateScore(sc);
    }
    

    // Lấy danh sách điểm theo classSubjectId
    @GetMapping("/scores/classSubject/{classSubjectId}")
    public ResponseEntity<List<Score>> getScoresByClassSubjectId(@PathVariable(value = "classSubjectId") int classSubjectId) {
        return new ResponseEntity<>(scoreService.getScoresByClassSubjectId(classSubjectId), HttpStatus.OK);
    }
    // Lấy danh sách điểm theo studentId
    @GetMapping("/scores/student/{studentId}")
    public ResponseEntity<List<Score>> getScoresByStudentId(@PathVariable(value = "studentId") int studentId) {
        return new ResponseEntity<>(scoreService.getScoresByStudentId(studentId), HttpStatus.OK);
    }
}
