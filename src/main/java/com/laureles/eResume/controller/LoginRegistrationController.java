package com.laureles.eResume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laureles.eResume.entity.Login;
import com.laureles.eResume.services.LoginService;


@Controller
@RequestMapping("/registration")
public class LoginRegistrationController {
	
	private LoginService loginService;
	
	
	public LoginRegistrationController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	@ModelAttribute("user")
	public Login login() {
		return new Login();
	}
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		return "register";
	}
	
	@PostMapping
	public String registerAdminUserAccount(@ModelAttribute("user") Login login) {
		loginService.save(login);
		return "redirect:/";
	}
	

}
