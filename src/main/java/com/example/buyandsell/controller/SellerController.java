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

import com.example.buyandsell.dto.sellerDTO;
import com.example.buyandsell.model.Category;
import com.example.buyandsell.model.SellerProduct;
import com.example.buyandsell.service.CategoryService;
import com.example.buyandsell.service.SellerService;

@Controller
public class SellerController {
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/sellerImages";
	@Autowired
	CategoryService categoryservice;
	@Autowired 
	SellerService sellerservice;
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
		model.addAttribute("products", sellerservice.getsellerproduct());
		return "products";
		
	}
	@GetMapping("/seller/products/add")
	public String productAddGet(Model model) {
		model.addAttribute("sellerDTO", new sellerDTO());
		model.addAttribute("categories", categoryservice.getallcategory());
		return "seller";
		
	}
	@PostMapping("/seller/products/add")
	public String productAddPost(@ModelAttribute("sellerDTO")sellerDTO sellerDTO,@RequestParam("sellerImage")MultipartFile file,
			@RequestParam("imgName")String imgName) throws IOException{
		
		SellerProduct product = new SellerProduct();
		product.setId(sellerDTO.getId());
		product.setName(sellerDTO.getName());
		product.setCategory(categoryservice.getCategoryById(sellerDTO.getCategoryid()).get());
		product.setPrice(sellerDTO.getPrice());
		product.setPhonenumber(sellerDTO.getPhonenumber());
		product.setAccountDescription(sellerDTO.getAccountDescription());
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir,imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		}else {
			imageUUID = imgName;
		}
		product.setImagename(imageUUID);
		
		sellerservice.addsellerproduct(product);
		
		return "redirect:/seller/products";
	}
	@GetMapping("/seller/product/delete/{id}")
	public String deleteProduct(@PathVariable long id) {
		sellerservice.removeproductbyid(id);
		return "redirect:/seller/products";
		
	}
	@GetMapping("/seller/product/update/{id}")
	public String updateProductGet(@PathVariable long id, Model model) {
		SellerProduct product = sellerservice.getProductById(id).get();
		sellerDTO sellerproductDTO = new sellerDTO();
		sellerproductDTO.setId(product.getId());
		sellerproductDTO.setName(product.getName());
		sellerproductDTO.setCategoryid((product.getCategory().getId()));
		sellerproductDTO.setPrice(product.getPrice());
		sellerproductDTO.setPhonenumber((product.getPhonenumber()));
		sellerproductDTO.setAccountDescription((product.getAccountDescription()));
		sellerproductDTO.setImagename(product.getImagename());
		model.addAttribute("categories",categoryservice.getallcategory());
		model.addAttribute("sellerDTO",sellerproductDTO);
		return "seller";
	}
}
