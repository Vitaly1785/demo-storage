package com.example.demostorage.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 128, unique = true, nullable = false)
    private Long id;

    @Column(name = "name", length = 128)
    private String name;
}
