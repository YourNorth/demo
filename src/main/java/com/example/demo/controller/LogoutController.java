package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    String getLogout(Model model, Authentication authentication){
        System.out.println("" +
                "\n======================================================================\n" +
                "LOGOUT PAGE\n" +
                "======================================================================\n");
        return "redirect:login";
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/logout")
    String postLogout(Model model){
        return "logout";
    }
}
