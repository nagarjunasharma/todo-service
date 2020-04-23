package com.nslearning.todoservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nslearning.todoservice.model.Category;
import com.nslearning.todoservice.repository.CategoryRepository;
import com.nslearning.todoservice.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository repository;

	@Override
	public Category findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Category> findByUserId(long userId) {
		return repository.findByUserId(userId).orElse(null);
	}

	@Override
	public Category saveOrUpdate(Category item) {
		return repository.save(item);
	}

	@Override
	public void delete(Category item) {
		repository.delete(item);
	}
	
	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
