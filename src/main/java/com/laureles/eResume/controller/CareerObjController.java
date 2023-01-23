package com.laureles.eResume.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.laureles.eResume.entity.CareerObj;
import com.laureles.eResume.services.CareerObjService;

@Controller
public class CareerObjController {
	
	private CareerObjService careerObjService;

	public CareerObjController(CareerObjService careerObjService) {
		super();
		this.careerObjService = careerObjService;
	}
	
		//handler method to handle list of CareerObj and return mode and view
		@GetMapping("/careerobj")
		public String listCareerObj(Model model) {
			model.addAttribute("careerobj", careerObjService.getAllCareerObj());
			return "career_objective";	
		}
		
		@GetMapping("/careerobj/new")
		public String createCareerObjForm(Model model){
			
			//create CareerObj object to hold CareerObj data
			CareerObj careerObj = new CareerObj();
			model.addAttribute("careerobj", careerObj);
			return "career_objective";	
		}
		
		@PostMapping("/careerobj")
		public String saveCareerObj(@ModelAttribute("careerobj") CareerObj careerObj) {
			careerObjService.saveCareerObj(careerObj);
			return "redirect:/careerobj";
		}
		
		@GetMapping("/careerobj/edit/{id}")
		public String editCareerObjForm(@PathVariable Long id, Model model){
			model.addAttribute("careerobj", careerObjService.getCareerObjById(id));
			return "edit_career_obj";
		}
		
		@PostMapping("/careerobj/{id}")
		public String updateCareerObj(Long id, @ModelAttribute("careerobj") CareerObj careerObj, Model model){
			
			//get CareerObj from database from ID
			CareerObj existingCareerObj = careerObjService.getCareerObjById(id);
			existingCareerObj.setId(id);
			existingCareerObj.setName(careerObj.getName());
			existingCareerObj.setDescription(careerObj.getDescription());
			existingCareerObj.setReason(careerObj.getReason());
			existingCareerObj.setTargetDate(careerObj.getTargetDate());
			existingCareerObj.setCompletedDate(careerObj.getCompletedDate());
			
			
			//save update CareerObj object
			careerObjService.updateCareerObj(existingCareerObj);
			return "redirect:/careerobj";
		}
		
		//handler method to handle delete CareerObj request
		@GetMapping("/careerobj/{id}")
		public String deleteCareerObj(@PathVariable Long id){
			careerObjService.deleteCareerObjById(id);
			return "redirect:/careerobj";
		}
	

}
