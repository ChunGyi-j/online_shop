package com.jdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jdc.model.entity.Account;
import com.jdc.services.AccountService;

@Controller
public class AccountController {

	private final AccountService accountservice;

	public AccountController(AccountService accountservice) {
		super();
		this.accountservice = accountservice;
	}

	@GetMapping("/sign")
	public String sign(Model model) {
		model.addAttribute("account", new Account());
		return "sign";
	}

	@PostMapping("/firstregister")
	public String createAccount(Account account,Model model) {
		model.addAttribute("account",account);
		return "address";
	}

	@PostMapping("/sign")
	public String createAddress(Account account) {
		accountservice.createAccount(account);
		return "home";
	}

	@GetMapping("/profile")
	public String profile(Model model) {
		return "profile";

	}

}
