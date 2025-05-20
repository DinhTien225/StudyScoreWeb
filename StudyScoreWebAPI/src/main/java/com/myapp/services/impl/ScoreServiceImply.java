/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.services.impl;

import com.myapp.pojo.Score;
import com.myapp.repositories.ScoreRepository;
import com.myapp.services.ScoreService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ADMIN
 */
@Service
public class ScoreServiceImply implements ScoreService {

    @Autowired
    public ScoreRepository scoreRepo;

    @Override
    public List<Score> getScores(Map<String, String> params) {
        return this.scoreRepo.getScores(params);
    }

    @Override
    public Score getScoreById(int id) {
        return this.scoreRepo.getScoreById(id);
    }

    @Override
    public Score addOrUpdateScore(Score sc) {
        return this.scoreRepo.addOrUpdateScore(sc);
    }

    @Override
    public void deleleScore(int id) {
        this.scoreRepo.deleleScore(id);
    }

    @Override
    public long countScores(Map<String, String> params) {
        return this.scoreRepo.countScores(params);
    }

    @Override
    public List<Score> getScoresByClassSubjectId(int classSubjectId) {
        return this.scoreRepo.getScoresByClassSubjectId(classSubjectId);
    }

    @Override
    public void lockScoresByClassSubjectId(int classSubjectId) {
        List<Score> scores = scoreRepo.getScoresByClassSubjectId(classSubjectId);

        for (Score s : scores) {
            s.setLockStatus("locked");  
        }

        this.scoreRepo.saveAll(scores);

//        // (Tùy chọn) Gửi email cho sinh viên thông báo điểm đã được khóa
//        for (Score s : scores) {
//            String email = s.getStudentId().getEmail(); // nếu có getEmail()
//            // Gửi email tại đây, dùng service hoặc tạo async queue
//        }
    }

    @Override
    public List<Score> getScoresByStudentId(int studentId) {
        return this.scoreRepo.getScoresByStudentId(studentId);
    }

}
