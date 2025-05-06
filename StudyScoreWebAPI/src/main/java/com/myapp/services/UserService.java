/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.services;

import com.myapp.pojo.User;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
public interface UserService extends UserDetailsService{
    User getUserByEmail(String email);
    User addUser(Map<String, String> params, MultipartFile avatar);
    boolean authenticate(String email, String password);
    
}
