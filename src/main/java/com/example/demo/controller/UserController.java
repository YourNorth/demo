package com.example.demo.controller;

import com.example.demo.form.UserForm;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/users")
    String users(Model model) {
        System.out.println("" +
                "\n======================================================================\n" +
                "USERS PAGE\n" +
                "======================================================================\n");
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }

    /*@PostMapping("/users/add")
    String addUser(Model model, @ModelAttribute("userForm") UserForm userForm) {
        System.out.println((userForm.toString()));
        userRepository.save(
                User.builder()
                        .name(userForm.getName())
                        .email(userForm.getEmail())
                        .password(userForm.getPassword())
                        .build());
        return "redirect:/users";
    }*/
}
