package com.example.demo.form;

import lombok.*;

import javax.annotation.security.DenyAll;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class UserForm {
    private String name;
    private String email;
    private String password;
}
