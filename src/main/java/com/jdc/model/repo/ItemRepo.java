package com.jdc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdc.model.entity.Item;
@Repository
public interface ItemRepo extends JpaRepository<Item, Long>{
	
	
}
