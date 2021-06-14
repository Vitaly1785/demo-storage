package com.example.demostorage.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "persons")
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 256, unique = true, nullable = false)
    private Long id;

    @Column(name = "login", length = 128)
    private String login;

    @Column(name = "password", length = 512)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
