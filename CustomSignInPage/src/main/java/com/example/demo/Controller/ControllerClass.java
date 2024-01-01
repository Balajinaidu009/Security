package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RestController
@RequestMapping
public class ControllerClass {
	@GetMapping("/admin")
	public String adminpage() {
		
		return "adminPage";
	}
	@GetMapping("/normal")
	public String normalPage() {
		return "Normal Page";
	}
	
	@GetMapping("/loginpage")
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		System.out.println("Method called");
		
		return mv;
	}

}
