package com.example.buyandsell.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.buyandsell.global.GlobalData;
import com.example.buyandsell.model.Role;
import com.example.buyandsell.model.User;
import com.example.buyandsell.repository.RoleRepository;
import com.example.buyandsell.repository.UserRepository;



@Controller
public class LoginController {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	UserRepository userrepository;
	@Autowired
	RoleRepository rolerepository;
	
	@GetMapping("/login")
	public String login() {
		GlobalData.cart.clear();
		return "login";
	}
	@GetMapping("/register")
	public String registerGet() {
		return "register";
	}
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException{
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role> roles = new ArrayList<>();
		user.setRoles(roles);
		userrepository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
}

}
