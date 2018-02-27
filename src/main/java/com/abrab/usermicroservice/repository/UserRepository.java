package com.abrab.usermicroservice.repository;

import com.abrab.usermicroservice.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public Page<User> findByCinContains(String mc, Pageable pageable);

}
