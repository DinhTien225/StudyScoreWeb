/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.controllers;

import com.myapp.services.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ADMIN
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/login")
    public String loginView() {
        return "login";
    }
    
    @GetMapping("/createLecturer")
    public String showCreateUserForm() {
        return "createLecturer";  // tên file HTML form
    }

    @PostMapping("/createLecturer/add")
    public String createUser(@RequestParam Map<String, String> params,
                             @RequestParam(value = "avatar", required = false) MultipartFile avatar,
                             Model model) {
        try {
            userService.addLecturer(params, avatar);
            model.addAttribute("message", "Tạo tài khoản thành công");
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi tạo tài khoản: " + e.getMessage());
        }
        return "createLecturer";
    }
}
