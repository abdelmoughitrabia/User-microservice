package com.abrab.usermicroservice;

import com.abrab.usermicroservice.domain.User;
import com.abrab.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class UserMicroserviceApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(UserMicroserviceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        User user = new User("EE348934", "Ra", "Abdo", "0665348934", "address",new Date());
//        User user2 = new User("QS32434", "Akam", "Fati", "098675564", "address",new Date());
//        User user3 = new User("YU568734", "Mimi", "Said", "0765237833", "address",new Date());
//        userRepository.save(user);
//        userRepository.save(user2);
//        userRepository.save(user3);
    }
}
