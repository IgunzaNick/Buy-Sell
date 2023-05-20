package com.example.codingdrips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.codingdrips.global.GlobalData;
import com.example.codingdrips.service.CategoryService;
import com.example.codingdrips.service.ProductService;

@Controller
public class HomeController {
		
		
		@GetMapping({"/","/home"})
		public String home(Model model) {
			return "index";	
		}
		

}

