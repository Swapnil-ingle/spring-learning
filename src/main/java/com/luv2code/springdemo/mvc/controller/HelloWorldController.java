package com.luv2code.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "processForm";
	}
	
	// New controller that adds data to model
	@RequestMapping("processFormV2")
	public String letsShoutDude(
			@RequestParam("studentName") String name,
			Model model) {
		String message = name.toUpperCase();
		model.addAttribute("message", "Yo! " + message);
		return "processFormV2";
	}
}
