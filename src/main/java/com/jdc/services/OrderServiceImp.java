package com.jdc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jdc.model.entity.Item;
import com.jdc.model.entity.Shop;
import com.jdc.model.entity.Order;
import com.jdc.model.repo.OrderRepo;

@Service
public class OrderServiceImp implements OrderService{
	
	private final OrderRepo ShopItemRepo;
	
	public OrderServiceImp(com.jdc.model.repo.OrderRepo shopItemRepo) {
		super();
		ShopItemRepo = shopItemRepo;
	}

	@Override
	public List<Item> find(Shop shop) {
		List<Order> shopItem = ShopItemRepo.findByShop(shop);
		 	List<Item> items =shopItem.stream().map(a->a.getItem()).collect(Collectors.toList());
		 	return items;
	}

}
