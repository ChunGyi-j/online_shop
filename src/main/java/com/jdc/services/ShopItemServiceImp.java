package com.jdc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jdc.model.entity.Item;
import com.jdc.model.entity.Shop;
import com.jdc.model.entity.ShopItem;
import com.jdc.model.repo.ShopItemRepo;

@Service
public class ShopItemServiceImp implements ShopItemService{
	
	private final ShopItemRepo ShopItemRepo;
	
	public ShopItemServiceImp(com.jdc.model.repo.ShopItemRepo shopItemRepo) {
		super();
		ShopItemRepo = shopItemRepo;
	}

	@Override
	public List<Item> find(Shop shop) {
		List<ShopItem> shopItem = ShopItemRepo.findByShop(shop);
		 	List<Item> items =shopItem.stream().map(a->a.getItem()).collect(Collectors.toList());
		 	return items;
	}

}
