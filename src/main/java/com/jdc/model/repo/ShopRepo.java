package com.jdc.model.repo;
import com.jdc.model.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepo extends JpaRepository<Shop,Long> {
	
	Shop findByAccountEmail(String email);



}


