package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        System.out.println("" +
                "\n======================================================================\n" +
                "GREETING PAGE\n" +
                "======================================================================\n");
        model.addAttribute("name", name);
        return "greeting";
    }

}