/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.myapp.hibernateweb;

import com.myapp.repositories.impl.ClassRepositoryImply;
/**
 *
 * @author ADMIN
 */
public class HibernateWeb {

    public static void main(String[] args) {
        ClassRepositoryImply s =new ClassRepositoryImply();
        s.getClasses().forEach(c -> System.out.println(c.getName()));
    }
}
