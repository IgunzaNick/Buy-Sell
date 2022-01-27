package com.example.buyandsell.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buyandsell.model.Category;
import com.example.buyandsell.repository.CategoryRepository;
@Service
public class CategoryService {
	@Autowired 
	CategoryRepository categoryrepository;
	public List<Category> getallcategory(){
		return categoryrepository.findAll();
	}
	public void addCategory(Category category) {
		categoryrepository.save(category);
		
	}
	public void removeCategoryById(int id) {
		categoryrepository.deleteById(id);
		
	}
	public Optional<Category> getCategoryById(int id) {
		return categoryrepository.findById(id);
		
	}

}
