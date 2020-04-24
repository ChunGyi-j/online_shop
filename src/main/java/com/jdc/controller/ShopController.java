package com.jdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.model.entity.Shop;
import com.jdc.services.ShopService;

@Controller
@RequestMapping
public class ShopController {
	
	private final ShopService shopservice;
	
	public ShopController(ShopService shopservice) {
		super();
		this.shopservice = shopservice;
	}

	@GetMapping("/createshop")
	public String create(Model model){
		model.addAttribute("shop",new Shop());
		return"multi-step-form";
	}
	@PostMapping("/create")
	public String createShop(Shop shop) {
	shopservice.createShop(shop);
		return "home";
	}
	
	

	


}
