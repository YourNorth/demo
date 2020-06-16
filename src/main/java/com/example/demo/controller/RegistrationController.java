package com.example.demo.controller;

import com.example.demo.form.UserForm;
import com.example.demo.model.Role;
import com.example.demo.model.State;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Controller
public class RegistrationController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("permitAll()")
    @GetMapping("/sign_up")
    String getSignUp(Model model, Authentication authentication){
        System.out.println("" +
                "\n======================================================================\n" +
                "SIGN UP PAGE\n" +
                "======================================================================\n");
        UserForm userForm = new UserForm();
        model.addAttribute("registrationForm", userForm);
        if(authentication==null||!authentication.isAuthenticated())
            return "signUp";
        else
            return "redirect:profile";
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/sing_up")
    String postSignUp(Model model, @ModelAttribute("registrationForm") UserForm userForm){
            System.out.println((userForm.toString()));
            Set<Role> roles = new HashSet<>();
            roles.add(new Role(1l,"ROLE_USER"));
            userRepository.save(
                    User.builder()
                            .name(userForm.getName())
                            .email(userForm.getEmail())
                            .password(passwordEncoder.encode(userForm.getPassword()))
                            .state(State.valueOf("CONFIRMED"))
                            .roles(roles)
                            .build());
            return "redirect:login";
    }
}
