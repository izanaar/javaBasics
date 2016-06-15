package com.izanaar.jpa.data.repository;

import com.izanaar.jpa.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
