package com.bookStore.repository;

import com.bookStore.entity.UserCreate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCreateRepository extends JpaRepository<UserCreate, Long> {
    // Custom query methods can go here if needed
}
