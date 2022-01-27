package com.example.buyandsell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.buyandsell.model.SellerProduct;

@Repository
public interface SellerRepository extends JpaRepository<SellerProduct,Integer> {
	List<SellerProduct> findAllByCategory_Id(int id);

}
