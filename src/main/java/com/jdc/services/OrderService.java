package com.jdc.services;

import java.util.List;

import com.jdc.model.entity.Item;
import com.jdc.model.entity.Shop;

public interface OrderService {

	List<Item> find(Shop shop);
}
