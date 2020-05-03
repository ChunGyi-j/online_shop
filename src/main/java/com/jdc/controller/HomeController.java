package com.jdc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdc.model.entity.Account;
import com.jdc.services.AccountService;
import com.jdc.services.ItemService;

@Controller
@RequestMapping()
public class HomeController {

	private final ItemService itemService;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private AccountService accountService;

	public HomeController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@GetMapping("/")
	public String showItem(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Account account = accountService.findByEmail(auth.getName());

		if (auth.getName().equals("anonymousUser")) {
			model.addAttribute("items", itemService.findTopItem());
			return "home";
		}
		System.out.println(account.getRole());
		if (account.getRole().toString().equals("Admin")) {
			return "adminHome";
		}
		model.addAttribute("items", itemService.findTopItem());
		return "home";
	}

}
