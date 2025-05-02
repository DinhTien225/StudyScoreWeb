/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.hibernateweb;

import com.myapp.pojo.Class;
import com.myapp.pojo.ClassSubject;
import com.myapp.pojo.Score;
import com.myapp.pojo.Subject;
import com.myapp.pojo.User;
import com.myapp.pojo.ForumComment;
import com.myapp.pojo.ForumPost;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author ADMIN
 */
public class HibernateUtils {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        Properties props = new Properties();
        props.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.setProperty(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
        props.setProperty(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/studentscoredb");
        props.setProperty(Environment.JAKARTA_JDBC_USER, "root");
        props.setProperty(Environment.JAKARTA_JDBC_PASSWORD, "Admin@123");
        props.setProperty(Environment.SHOW_SQL, "true");
        
        conf.setProperties(props);
        
        conf.addAnnotatedClass(Class.class);
        conf.addAnnotatedClass(ClassSubject.class);
        conf.addAnnotatedClass(ForumComment.class);
        conf.addAnnotatedClass(ForumPost.class);
        conf.addAnnotatedClass(Score.class);
        conf.addAnnotatedClass(Subject.class);
        conf.addAnnotatedClass(User.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        
        FACTORY = conf.buildSessionFactory(serviceRegistry);
    }
    
    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
}
