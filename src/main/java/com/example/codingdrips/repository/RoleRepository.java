package com.example.codingdrips.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.codingdrips.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
	

}
