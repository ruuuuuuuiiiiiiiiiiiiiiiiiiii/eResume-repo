package com.laureles.eResume.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.laureles.eResume.entity.Login;


public interface LoginService extends UserDetailsService{

	//List Login Feature
		List<Login> getAllLoginCredential();
		
//		Login saveLogin(Login login);
		
		Login getLoginById(Long id);
		
		Login updateLogin(Login Login);
		
		void deleteLoginById(Long id);

		Login save(Login login);
		
		
	
}
