package com.nslearning.todoservice.services;

import java.util.List;

import com.nslearning.todoservice.model.Category;

public interface CategoryService {
	
	public Category findById(long id);
	
	public List<Category> findByUserId(long userId);
	
	public Category saveOrUpdate(Category item);
	
	public void delete(Category item);
	
	public void deleteById(long id);

}
