package com.laureles.cgi.services.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.laureles.cgi.entity.Login;
import com.laureles.cgi.entity.LoginRole;
import com.laureles.cgi.repository.LoginRepository;
import com.laureles.cgi.services.LoginService;




@Service
public class LoginServiceImpl implements LoginService{

	private LoginRepository loginRepository;
	
	
	public LoginServiceImpl(LoginRepository loginRepository) {
		super();
		this.loginRepository = loginRepository;
	}

	@Override
	public List<Login> getAllLoginCredential() {
		
		return loginRepository.findAll();
	}

//	@Override
//	public Login saveLogin(Login login) {
//		// TODO Auto-generated method stub
//		return loginRepository.save(login);
//	}

	@Override
	public Login getLoginById(Long id) {
		
		return loginRepository.findById(id).get();
	}

	@Override
	public Login updateLogin(Login login) {
		
		return loginRepository.save(login);
	}

	@Override
	public void deleteLoginById(Long id) {
		loginRepository.deleteById(id);
		
	}
	
	

	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	

	@Override
	public Login save(Login login) {
		Login login1 = new Login(login.getName(), 
				login.getEmail(), login.getUserName(), 
				passwordEncoder.encode(login.getPassword()), Arrays.asList(new LoginRole("ROLE_USER")));
		
		return loginRepository.save(login1);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = loginRepository.findByUserName(username);
		if (login == null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(login.getUserName(),login.getPassword(), mapRolesToAuthorities(login.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<LoginRole> adminRoles){
		return adminRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
