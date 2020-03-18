package com.jdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.Data;

@Controller
@Data
public class HomeController {
	@PostMapping("/home")
	public String home() {
		return "home";
	}

}
