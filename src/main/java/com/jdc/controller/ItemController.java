package com.jdc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.model.entity.Cart;
import com.jdc.model.entity.Item;
import com.jdc.services.AccountService;
import com.jdc.services.CategoryService;
import com.jdc.services.ItemService;
import com.jdc.services.OrderService;
import com.jdc.services.ShopService;

@Controller
public class ItemController {

	private final ItemService itemService;
	private final CategoryService categoryService;
	private final AccountService accountService;
	private final OrderService shopItemService;
	private final ShopService shopService;
	@Autowired
	private Cart cart;

	public ItemController(ItemService itemService, ShopService shopSerivce, OrderService shopItemService,
			AccountService accountService, CategoryService categoryService) {
		super();
		this.itemService = itemService;
		this.categoryService = categoryService;
		this.accountService = accountService;
		this.shopItemService = shopItemService;
		this.shopService = shopSerivce;
	}

	@GetMapping("/additem")
	public String item(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("categories", categoryService.findAll());
		return "addItem";
	}

	@PostMapping("/additem")
	public String additem(@RequestParam MultipartFile files, Item item, BindingResult result)
			throws IllegalStateException, IOException {
		if (result.hasErrors()) {
			return "/additem";
		}

		itemService.save(files, item);
		return "redirect:/";
	}
	//AddToCart
	@GetMapping("itemdetail{id:\\d+}")
	public String findProductsById(@PathVariable(name = "id") Long id, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			model.addAttribute("cartSize", session.getAttribute("cartSize"));
		}
		model.addAttribute("item", itemService.findByItemId(id));
		return "itemdetail";
	}
}