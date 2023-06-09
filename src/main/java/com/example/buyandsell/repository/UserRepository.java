package com.example.buyandsell.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buyandsell.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
	Optional<User> findUserByEmail(String email);

}
