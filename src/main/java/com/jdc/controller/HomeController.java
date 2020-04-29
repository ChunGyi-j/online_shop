package com.jdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.services.ItemService;

@Controller
@RequestMapping
public class HomeController {
	
	private final ItemService itemService;
	@Autowired
	private  BCryptPasswordEncoder encoder;

	
	public HomeController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@GetMapping("/")
	public String showItem(Model model) {
		model.addAttribute("items",itemService.findTopItem());
		String password1="1234";
		String password2="1234";
		System.out.println(encoder.encode(password1).toString()+" -password1");
		System.out.println(encoder.encode(password2).toString()+ "- password2");
	
		return "home";
	}

}
