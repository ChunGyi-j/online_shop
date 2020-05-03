package com.jdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.model.entity.Account;
import com.jdc.model.entity.Shop;
import com.jdc.services.AccountService;
import com.jdc.services.ShopService;

@Controller
@RequestMapping
public class ShopController {
	
	private final ShopService shopservice;
	private final AccountService accountService;

	
	public ShopController(ShopService shopservice,AccountService accountService) {
		super();
		this.shopservice = shopservice;
		this.accountService = accountService;
		
	}

	@GetMapping("/createshop")
	public String create(Model model){
		if(accountService.loginAccount().getRole().toString().equals("Shopkeeper")) {
			Account account = accountService.loginAccount();
			Shop shop = shopservice.findByAccount(account.getEmail());
			model.addAttribute("shopkeeper",shop);
			return "ShopKeeper";
		}
		model.addAttribute("shop",new Shop());
		return"multi-step-form";
	}
	
	@PostMapping("/create")
	public String createShop(Shop shop) {
	shopservice.createShop(shop);
		return "home";
	}
	
	@GetMapping("/history")
	public String history() {
		return "orderHistory";
	}
	
	

	


}
