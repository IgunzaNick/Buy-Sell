package com.example.buyandsell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buyandsell.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
