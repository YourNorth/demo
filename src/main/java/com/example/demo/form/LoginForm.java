package com.example.demo.form;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
public class LoginForm {
    private String name;
    private String password;
}
