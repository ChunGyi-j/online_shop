package com.jdc.common;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jdc.model.entity.Item;
import com.jdc.services.ItemService;

@ControllerAdvice
public class CommonAdvice {
	
	
	private final ItemService itemService;
	
	
	public CommonAdvice(ItemService itemService) {
		super();
		this.itemService = itemService;
	}

	@ModelAttribute("items")
	public List<Item> showItem() {
		return itemService.findTopItem();
	}

}
