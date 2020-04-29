package com.jdc.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jdc.model.entity.Category;
import com.jdc.model.repo.CategoryRepo;

@Service
public class CategoryServiceImp implements CategoryService{
	
	private final CategoryRepo categoryRepo;

	public CategoryServiceImp(CategoryRepo categoryRepo) {
		super();
		this.categoryRepo = categoryRepo;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepo.findAll();
	}

}
