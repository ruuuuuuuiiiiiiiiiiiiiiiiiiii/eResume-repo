package com.laureles.cgi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.laureles.cgi.entity.Login;
import com.laureles.cgi.services.LoginService;



@Controller
public class LoginController {

	private LoginService loginService;

	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	
	
	//handler method to handle list of Login and return mode and view
	@GetMapping("/logincredential")
	public String listLogin(Model model) {
		model.addAttribute("login", loginService.getAllLoginCredential());
		return "logins";	
	}


	
	
	@GetMapping("/logins/new")
	public String createLoginForm(Model model){
		
		//create Login object to hold Login data
		Login login = new Login();
		model.addAttribute("logins", login);
		return "create_login";	
	}
	
//	@PostMapping("/logins")
//	public String saveLogin(@ModelAttribute("login") Login login) {
//		loginService.saveLogin(login);
//		return "redirect:/logins";
//	}
	
	@GetMapping("/logins/edit/{id}")
	public String editLoginForm(@PathVariable Long id, Model model){
		model.addAttribute("login", loginService.getLoginById(id));
		return "edit_login";
	}
	
	@PostMapping("/logins/{id}")
	public String updateLogin(@PathVariable Long id, @ModelAttribute("login") Login login, Model model){
		
		//get Login from database from ID
		Login existingLogin = loginService.getLoginById(id);
		existingLogin.setId(id);
		existingLogin.setName(login.getName());
		existingLogin.setEmail(login.getEmail());
		
		//save update Login object
		loginService.updateLogin(existingLogin);
		return "redirect:/logins";
	}
	
	//handler method to handle delete Login request
	@GetMapping("/logins/{id}")
	public String deleteLogin(@PathVariable Long id){
		loginService.deleteLoginById(id);
		return "redirect:/logins";
	}
}
