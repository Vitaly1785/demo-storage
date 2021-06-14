package com.example.demostorage.Repo;

import com.example.demostorage.entity.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepo extends CrudRepository<Image, Long> {
}
