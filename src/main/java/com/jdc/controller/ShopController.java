package com.jdc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.model.entity.Account;
import com.jdc.model.entity.Item;
import com.jdc.model.entity.Shop;
import com.jdc.services.AccountService;
import com.jdc.services.ItemService;
import com.jdc.services.ShopItemService;
import com.jdc.services.ShopService;

@Controller

public class ShopController {
	@Autowired
	private  ShopService shopservice;
	@Autowired
	private  AccountService accountService;
	@Autowired
	private  ShopItemService shopItemService;

	
	
	@GetMapping("/createshop")
	public String create(Model model){
		if(accountService.loginAccount().getRole().toString().equals("Shopkeeper")) {
			Account account = accountService.loginAccount();
			Shop shop = shopservice.findByAccount(account.getEmail());
			model.addAttribute("shopkeeper",shop);
			List<Item> items = shopItemService.find(shop);
			for (Item item : items) {
				System.out.println(item.getName());
			}
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
