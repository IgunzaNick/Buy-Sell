package com.example.buyandsell.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.buyandsell.model.CustomUserDetails;
import com.example.buyandsell.model.User;
import com.example.buyandsell.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	UserRepository userrepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user  = userrepository.findUserByEmail(email);
		return user.map(CustomUserDetails::new).get();
	}

}
