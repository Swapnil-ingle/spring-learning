package com.luv2code.springdemo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.mvc.container.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/input-form")
	public String showStudentForm(Model model) {
		model.addAttribute("student", new Student());
		return "student-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@ModelAttribute("student") Student student) {
		return "student-confirmation";
	}
}
