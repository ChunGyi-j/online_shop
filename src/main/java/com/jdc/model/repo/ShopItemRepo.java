package com.jdc.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdc.model.entity.Shop;
import com.jdc.model.entity.ShopItem;

@Repository
public interface ShopItemRepo extends JpaRepository<ShopItem,Long>{
	List<ShopItem> findByShop(Shop shop);
	
	
}
