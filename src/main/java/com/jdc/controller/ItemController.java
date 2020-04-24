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
import com.jdc.services.ItemService;

@Controller
public class ItemController {
	
	private final ItemService itemService;
	 
	
	public ItemController(ItemService itemService) {
		super();
		this.itemService = itemService;
	}
	@GetMapping("/additem")
	public String item(Model model) {
		model.addAttribute("item", new Item());
		return "addItem";
	}
	@PostMapping("/additem")
	    public String additem (@RequestParam MultipartFile files ,Item item,BindingResult result) throws IllegalStateException, IOException  {
		if (result.hasErrors()){
            return "/additem";
        }

		itemService.save(files, item);
		return"home";
	 }
	       

}
