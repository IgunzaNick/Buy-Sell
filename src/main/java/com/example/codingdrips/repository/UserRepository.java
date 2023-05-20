package com.example.codingdrips.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.codingdrips.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User> findUserByEmail(String email);

}
