package com.jdc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jdc.model.entity.Cart;
import com.jdc.model.entity.Item;
import com.jdc.services.ItemService;

@Controller
public class CartController {
	
	@Autowired
	private  Cart cart;
	@Autowired
	private ItemService itemService;
	 @GetMapping("addtocart{id:\\d+}")
	    public String addToCart(@PathVariable Long id, HttpServletRequest request){
	        boolean isExisted=false;
	        for(Item items:cart.getCartItem()){
	            if(items.getId()==id){
	                isExisted=true;
	            }
	        }
	        if(!isExisted){
	            cart.addToCart(itemService.findByItemId(id));
	        }

	        HttpSession session=request.getSession();
	        session.setAttribute("cartSize",cart.getCartSize());
	        return "redirect:/products/"+id;
	    }
}
