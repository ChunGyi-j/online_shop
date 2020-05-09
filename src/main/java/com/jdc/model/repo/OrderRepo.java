package com.jdc.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdc.model.entity.Shop;
import com.jdc.model.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long>{
	List<Order> findByShop(Shop shop);
	
	
}
