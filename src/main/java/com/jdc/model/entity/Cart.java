package com.jdc.model.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Cart {

	private int cartSize;
	private List<Integer> cartQuantity = new ArrayList<>();
	private Set<Item> cartItem = new HashSet<>();

	public int getCartSize() {
		return cartSize;
	}

	public void setCartSize(int cartSize) {
		this.cartSize = cartSize;
	}

	public List<Integer> getCartQuantity() {
		return cartQuantity;
	}

	public void setCartQuantity(List<Integer> cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

	public Set<Item> getCartItem() {
		return cartItem;
	}

	public void setCartItem(Set<Item> cartItem) {
		this.cartItem = cartItem;
	}

	public void clearCart() {
		this.cartItem.clear();
	}

	public void addToCart(Item item) {
		this.cartItem.add(item);
	}

}
