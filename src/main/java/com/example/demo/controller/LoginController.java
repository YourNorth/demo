package com.example.demo.controller;

import com.example.demo.form.LoginForm;
import com.example.demo.form.UserForm;
import com.example.demo.model.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class LoginController {
    @PreAuthorize("permitAll()")
    @GetMapping("/login")
    String getLogin(Model model){
        LoginForm loginForm = new LoginForm();
        model.addAttribute("loginForm", loginForm);
       System.out.println("" +
               "\n======================================================================\n" +
               "SIGN IN PAGE\n" +
               "======================================================================\n");
        return "login";
    }

    /*@PostMapping("/login")
    String postLogin(Model model, @ModelAttribute(value = "loginForm") LoginForm loginForm){
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
