package com.jdc.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jdc.model.entity.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{
	

}
