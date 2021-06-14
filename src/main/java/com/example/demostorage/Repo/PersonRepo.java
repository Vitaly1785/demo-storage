package com.example.demostorage.Repo;

import com.example.demostorage.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepo extends CrudRepository<Person, Long> {
    Optional<Person> findByLogin(String login);
}
