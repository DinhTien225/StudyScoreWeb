/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.repositories.impl;
import com.myapp.pojo.Class;

import com.myapp.hibernateweb.HibernateUtils;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class ClassRepositoryImply {
     public List<Class> getClasses() {
        try (Session s = HibernateUtils.getFACTORY().openSession()) {
            Query q = s.createQuery("FROM Class", Class.class);
            return q.getResultList();
        }
    }
}
