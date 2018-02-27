package com.abrab.usermicroservice.controller;

import com.abrab.usermicroservice.domain.User;
import com.abrab.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/pageUsers")
    public Page<User> getPageOfUsers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "0") int size,
            @RequestParam(name = "mc", defaultValue = "") String mc
    ) {
        return userRepository.findByCinContains(mc, new PageRequest(page, size, Sort.Direction.DESC, "dateCreation"));
    }

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable("id") Long id) {
        return userRepository.findOne(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        user.setDateCreation(new Date());
        return userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public User editUser(@RequestBody User user, @PathVariable("id") Long id) {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable("id") Long id) {
        try {
            userRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
