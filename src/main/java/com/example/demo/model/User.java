package com.example.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users"/*,uniqueConstraints = @UniqueConstraint(columnNames = "email")*/) //FIXme

@AllArgsConstructor
@Builder
@Data
@ToString
public class User{
    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long user_id;

    @Column(name = "email")
    private String email;

    private String name;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private State state;

}
