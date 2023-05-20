package com.example.codingdrips.configuaration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.codingdrips.model.Role;
import com.example.codingdrips.model.User;
import com.example.codingdrips.repository.RoleRepository;
import com.example.codingdrips.repository.UserRepository;



@Component
public class GoogleOauth2Successhandler implements AuthenticationSuccessHandler {
	@Autowired
	RoleRepository  rolerepository;
	@Autowired
	UserRepository userrepository;
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
		String email = token.getPrincipal().getAttributes().get("email").toString();
		if(userrepository.findUserByEmail(email).isPresent()) {
			
		}else {
		User user = new User();
		user.setFirstName(token.getPrincipal().getAttributes().get("given_name").toString());
		user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString());
		user.setEmail(email);
		List<Role> roles = new ArrayList<>();
		roles.add(rolerepository.findById(1).get());
		userrepository.save(user);
	}
	redirectStrategy.sendRedirect(request,response,"/");

}
}

