package com.example.buyandsell.configuaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.buyandsell.service.CustomUserDetailService;


@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter {
	@Autowired
	GoogleOauth2Successhandler googleOAuth2SuccessHandler;
	@Autowired
	CustomUserDetailService customUserDetailService;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()
				.antMatchers("/", "/register","/h2-console/**").permitAll()
				/*.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/shop").hasRole("BUYER")
				.antMatchers("/seller").hasRole("SELLER")*/
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.permitAll()
				.failureUrl("/login?error= true")
				.defaultSuccessUrl("/")
				.usernameParameter("email")
				.passwordParameter("password")
				.and()
				.oauth2Login()
				.loginPage("/login")
				.successHandler(googleOAuth2SuccessHandler)
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true)
				.deleteCookies("B&SSESSIONID")
				.and()
				.exceptionHandling()
				.and()
				.csrf()
				.disable();
				http.headers().frameOptions().disable();
	}
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(customUserDetailService);
	}
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/resources/**","/static/**","/images/**","/productimages/**","/js/**");
	}

}
