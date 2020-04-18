package com.jdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.model.entity.Shop;

@Controller
@RequestMapping
public class ShopController {
	
	@PostMapping("/create")
	public String createShop(@ModelAttribute("shop") Shop shop) {
		return "home";
	}
	
	

	


}
