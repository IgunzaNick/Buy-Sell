package com.example.codingdrips.controller;

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

import com.example.codingdrips.global.GlobalData;
import com.example.codingdrips.model.Role;
import com.example.codingdrips.model.User;
import com.example.codingdrips.repository.RoleRepository;
import com.example.codingdrips.repository.UserRepository;



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
		//roles.add(rolerepository.findById(1).get());
		user.setRoles(roles);
		userrepository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
}

}
