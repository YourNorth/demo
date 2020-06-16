package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @PreAuthorize("permitAll()")
    @GetMapping("/")
    String getRoot(Model model, Authentication authentication){
        System.out.println("" +
                "\n======================================================================\n" +
                "ROOT PAGE\n" +
                "======================================================================\n");
        if(authentication!=null&&authentication.isAuthenticated()){
            return "redirect:profile";
        }
        else return "redirect:login";
    }
}
