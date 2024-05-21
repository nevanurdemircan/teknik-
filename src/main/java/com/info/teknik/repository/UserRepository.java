package com.info.teknik.repository;

import com.info.teknik.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findFirstByMail(String email);
}
