package com.springbootbasiccrud.repository;

import com.springbootbasiccrud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
