package com.example.buyandsell.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buyandsell.model.SellerProduct;
import com.example.buyandsell.repository.SellerRepository;

@Service
public class SellerService {
	@Autowired SellerRepository sellerrepository;
	public List<SellerProduct>getsellerproduct(){
		return sellerrepository.findAll();
	}
	public void addsellerproduct(SellerProduct product) {
		sellerrepository.save(product);
		
	}
	public void removeproductbyid(long id) {
		sellerrepository.deleteById(id);
	}
	public Optional<SellerProduct> getProductById(long id){
		return sellerrepository.findById(id);
		
	}
	public List<SellerProduct>getAllProductsByCategoryID(int id){
		return sellerrepository.findAllByCategory_Id(id);
		
		
	}

}
