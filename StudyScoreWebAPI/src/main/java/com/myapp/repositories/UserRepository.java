/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.repositories;

import com.myapp.pojo.User;

/**
 *
 * @author ADMIN
 */
public interface UserRepository {
    User getUserByEmail(String email);
    User addUser(User u);
    boolean authenticate(String email, String password);
}
