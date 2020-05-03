package com.jdc.model.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdc.model.entity.Shop;

@Repository
public interface ShopRepo extends JpaRepository<Shop,Long> {
	
	Shop findByAccountEmail(String email);
	



}


