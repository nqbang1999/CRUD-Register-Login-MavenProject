package com.bangelevenn.CRUDRegisterLoginMaven.repository;

import com.bangelevenn.CRUDRegisterLoginMaven.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}


