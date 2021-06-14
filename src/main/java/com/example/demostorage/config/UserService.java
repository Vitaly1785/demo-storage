package com.example.demostorage.config;

import com.example.demostorage.Repo.PersonRepo;
import com.example.demostorage.entity.Person;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final PersonRepo personRepo;

    public UserService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = personRepo.findByLogin(s);
        if (!person.isPresent()){
            throw new UsernameNotFoundException("username not found");
        }
        Person personFind = person.get();
        return new User(personFind.getLogin(), personFind.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority(personFind.getRole().getName())));
    }
}
