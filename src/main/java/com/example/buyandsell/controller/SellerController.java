package com.example.buyandsell.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.buyandsell.dto.productDTO;
import com.example.buyandsell.model.Category;
import com.example.buyandsell.model.Product;
import com.example.buyandsell.service.CategoryService;
import com.example.buyandsell.service.ProductService;

@Controller
public class SellerController {
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
	@Autowired
	CategoryService categoryservice;
	@Autowired 
	ProductService productservice;
	@GetMapping("/seller")
	public String sellerpage() {
		return "seller";
		
	}
	@GetMapping("/seller/categories")
	public String getCategories(Model model) {
		model.addAttribute("categories", categoryservice.getallcategory());
		return "categories";
	
}
	@GetMapping("/seller/categories/add")
	public String getCategoriesAdd(Model model) {
		model.addAttribute("category",new Category());
		return "categoriesAdd";
	}
	@PostMapping("/seller/categories/add")
	public String postCategoriesAdd(@ModelAttribute("category") Category category) {
		categoryservice.addCategory(category);
		return "redirect:/seller/categories";
	}
	@GetMapping("/seller/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		categoryservice.removeCategoryById(id);
		return "redirect:/seller/categories";
		
	}
	@GetMapping("/seller/categories/update/{id}")
	public String updateCategory(@PathVariable int id,Model model) {
		Optional<Category> category = categoryservice.getCategoryById(id);
		if(category.isPresent()) {
			model.addAttribute("category",category.get());
			return "categoriesAdd";
		}else {
			return "404";
		}
	}
	//product section
	@GetMapping("/seller/products")
	public String products(Model model) {
		model.addAttribute("products", productservice.getallProduct());
		return "products";
		
	}
	@GetMapping("/seller/products/add")
	public String productAddGet(Model model) {
		model.addAttribute("productDTO", new productDTO());
		model.addAttribute("categories", categoryservice.getallcategory());
		return "productsAdd";
		
	}
	@PostMapping("/seller/products/add")
	public String productAddPost(@ModelAttribute("productDTO")productDTO productDTO,@RequestParam("productImage")MultipartFile file,
			@RequestParam("imgName")String imgName) throws IOException{
		
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
		product.setCategory(categoryservice.getCategoryById(productDTO.getCategoryid()).get());
		product.setPrice(productDTO.getPrice());
		product.setPhonenumber(productDTO.getPhonenumber());
		product.setDescription(productDTO.getDescription());
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		}else {
			imageUUID = imgName;
		}
		product.setImageName(imageUUID);
		
		productservice.addProduct(product);
		
		return "redirect:/seller/products";
	}
	@GetMapping("/seller/product/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		productservice.removeProductById(id);
		return "redirect:/seller/products";
		
	}
	@GetMapping("/seller/product/update/{id}")
	public String updateProductGet(@PathVariable long id, Model model) {
		Product product = productservice.getProductById(id).get();
		productDTO productDTO = new productDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setCategoryid((product.getCategory().getId()));
		productDTO.setPrice(product.getPrice());
		productDTO.setPhonenumber((product.getPhonenumber()));
		productDTO.setDescription((product.getDescription()));
		productDTO.setImageName(product.getImageName());
		model.addAttribute("categories",categoryservice.getallcategory());
		model.addAttribute("productDTO",productDTO);
		return "productsAdd";
	}
}
