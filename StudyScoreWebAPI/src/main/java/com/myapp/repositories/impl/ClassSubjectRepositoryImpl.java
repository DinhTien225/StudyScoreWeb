///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.myapp.repositories.impl;
//
//import com.myapp.hibernateweb.HibernateUtils;
//import com.myapp.pojo.ClassSubject;
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//
///**
// *
// * @author ADMIN
// */
//public class ClassSubjectRepositoryImply {
//    private static final int PAGE_SIZE = 6;
//    
//    // Gán môn học cho lớp
//    public ClassSubject assignSubjectToClass(ClassSubject classSubject) {
//        try (Session s = HibernateUtils.getFACTORY().openSession()) {
//            s.beginTransaction();
//            
//            if (classSubject.getId() == null) {
//                s.persist(classSubject);  // Thêm mới
//            } else {
//                s.merge(classSubject);    // Cập nhật
//            }
//            
//            s.refresh(classSubject); // Làm mới đối tượng
//            s.getTransaction().commit();
//            return classSubject;
//        }
//    }
//
//
//    // Tìm danh sách ClassSubject theo các tiêu chí (tìm kiếm theo tên lớp, tên môn học, phân trang)
//    public List<ClassSubject> getClassSubjects(Map<String, String> params) {
//        try (Session s = HibernateUtils.getFACTORY().openSession()) {
//            CriteriaBuilder b = s.getCriteriaBuilder();
//            CriteriaQuery<ClassSubject> q = b.createQuery(ClassSubject.class);
//            Root<ClassSubject> root = q.from(ClassSubject.class);
//            q.select(root);
//            
//            if (params != null) {
//                List<Predicate> predicates = new ArrayList<>();
//                
//                String kwClass = params.get("className");
//                if (kwClass != null && !kwClass.isEmpty()) {
//                    predicates.add(b.like(root.get("classId").get("name"), String.format("%%%s%%", kwClass)));
//                }
//                
//                String kwSubject = params.get("subjectName");
//                if (kwSubject != null && !kwSubject.isEmpty()) {
//                    predicates.add(b.like(root.get("subjectId").get("subjectName"), String.format("%%%s%%", kwSubject)));
//                }
//                
//                q.where(predicates.toArray(new Predicate[0]));
//                
//                String orderBy = params.get("orderBy");
//                if (orderBy != null && !orderBy.isEmpty()) {
//                    q.orderBy(b.asc(root.get(orderBy)));
//                }
//            }
//            
//            Query query = s.createQuery(q);
//            
//            if (params != null) {
//                int page = Integer.parseInt(params.getOrDefault("page", "1"));
//                int start = (page - 1) * PAGE_SIZE;
//                
//                query.setMaxResults(PAGE_SIZE);
//                query.setFirstResult(start);
//            }
//            
//            return query.getResultList();
//        }
//    }
//
//    // Tìm ClassSubject theo ID
//    public ClassSubject getClassSubjectById(int id) {
//        try (Session s = HibernateUtils.getFACTORY().openSession()) {
//            return s.get(ClassSubject.class, id);
//        }
//    }
//
//}
