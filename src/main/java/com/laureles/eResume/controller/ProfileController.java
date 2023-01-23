package com.laureles.eResume.controller;



import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.laureles.eResume.database.database;
import com.laureles.eResume.entity.Login;
import com.laureles.eResume.repository.LoginRepository;


@Controller
public class ProfileController {
	
	
	private final database db;
	private LoginRepository loginRepository;
	
	
	public ProfileController(database db, LoginRepository loginRepository) {
		super();
		this.db = db;	
		this.loginRepository = loginRepository;
	}
	
	@RequestMapping("/profile")
	public String profile(Model model, Principal principal) {
		Login loggedUser = loginRepository.findByUserName(principal.getName());
		model.addAttribute("user", loggedUser);
//        model.addAttribute("isAdmin", adminUserRepository.isAdmin(loggedUser));
        model.addAttribute("pageTitle", "Profile | CGI-DEMO");
//        model.addAttribute("isUnread", nr.isThereUnread(loggedUser.getId()));
//
//        model.addAttribute("completedBugs", completedBugsCount(loggedUser.getId()));
//        model.addAttribute("completedTasks", completedTasksCount(loggedUser.getId()));
//
//        model.addAttribute("changePassword", new ChangePassword());		
		
		
		
		return "profile";
	}
	

}
