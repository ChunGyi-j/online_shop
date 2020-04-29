package com.jdc.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.model.entity.Item;
import com.jdc.services.CategoryService;
import com.jdc.services.ItemService;

@Controller
public class ItemController {
	
	private final ItemService itemService;
	private final CategoryService categoryService;
	 
	
	
	public ItemController(ItemService itemService, CategoryService categoryService) {
		super();
		this.itemService = itemService;
		this.categoryService = categoryService;
	}
	@GetMapping("/additem")
	public String item(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("categories",categoryService.findAll() );
		return "addItem";
	}
	@PostMapping("/additem")
	    public String additem (@RequestParam MultipartFile files ,Item item,BindingResult result) throws IllegalStateException, IOException  {
		if (result.hasErrors()){
            return "/additem";
        }

		itemService.save(files, item);
		return "redirect:/";
	 }
	       

}
