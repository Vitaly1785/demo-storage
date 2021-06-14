package com.example.demostorage.entity;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length = 36, unique = true, nullable = false)
    private Long id;

    @Column(name = "url", length = 512)
    private String url;
}
