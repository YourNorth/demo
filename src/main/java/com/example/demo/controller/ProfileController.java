package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.security.details.UserDetailsImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    String getProfile(Model model, Authentication authentication) {
        System.out.println("" +
                "\n======================================================================\n" +
                "PROFILE PAGE\n" +
                "======================================================================\n");
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println("\n====================================================\n" +
                userDetailsImpl + "\n=============================================================\n");
        User user = userDetailsImpl.getUser();
        model.addAttribute("usver", user);
        return "profile";
    }
}
