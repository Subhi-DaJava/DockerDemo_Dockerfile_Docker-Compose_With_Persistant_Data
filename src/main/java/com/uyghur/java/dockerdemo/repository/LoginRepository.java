package com.uyghur.java.dockerdemo.repository;

import com.uyghur.java.dockerdemo.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByUsername(String username);
}
