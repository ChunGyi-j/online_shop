package com.jdc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.model.entity.Account;
import com.jdc.services.AccountService;
import com.jdc.services.ItemService;

@Controller
@RequestMapping
public class ProfileController {

	private final AccountService AccountService;
	private final ItemService itemService;

	public ProfileController(AccountService accountService,ItemService itemSerivce) {
		super();
		this.AccountService = accountService;
		this.itemService = itemSerivce;
	}

	@GetMapping("/MemberProfile")
	public String memberProfile(Model model) {
		Account member = AccountService.loginAccount();
		model.addAttribute("member", member);
		model.addAttribute("sellProducts",itemService.findProfileProdcuts(member.getId()));
		return "profile";
	}

	@PostMapping("/ChangeProfilePhoto")
	public String editProfilePhoto(@RequestParam MultipartFile profilePhoto, @ModelAttribute("member") Account member) {
		Account account = AccountService.findById(member.getId());
		AccountService.editMemberProfilePhoto(profilePhoto, account);
		return "redirect:/MemberProfile";

	}

	@PostMapping("/ChangeProfileName")
	public String editProfileName(@ModelAttribute("memeber") Account member) {
		Account account = AccountService.findById(member.getId());
		account.setName(member.getName());
		AccountService.editMemberProfileName(account);
		return "redirect:/MemberProfile";
	}

	@PostMapping("/ChangeProfilePassword")
	public String editProfilePassword(@ModelAttribute Account member, @RequestParam String oldPassword,
			@RequestParam String newPassword, @RequestParam String confirm) {
		Account account = AccountService.findById(member.getId());

		
		/*
		 * if(!AccountService.samePassword(account, oldPassword)) {
		 * System.out.println("mar"); return "redirect:/MemberProfile"; }
		 * 
		 */
		if (!newPassword.equals(confirm)) {
			System.out.println("ma too password");
			return "redirect:/MemberProfile";
		}
		AccountService.editMemberProfilePassword(account, newPassword);
		return "redirect:/MemberProfile";
	}
	@PostMapping("/ChangeProfileAddress")
	public String editProfileAddress(@ModelAttribute Account member) {
		Account account = AccountService.findById(member.getId());
		account.setAddress(member.getAddress());
		 AccountService.createAccount(account);
		 return "redirect:/MemberProfile";
	}
	@GetMapping("/AdminProfile")
	public String adminProfile() {
		return "adminProfile";
	}
}
