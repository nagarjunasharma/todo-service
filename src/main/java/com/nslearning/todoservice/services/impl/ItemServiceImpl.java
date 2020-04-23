package com.nslearning.todoservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nslearning.todoservice.model.Item;
import com.nslearning.todoservice.repository.ItemRepository;
import com.nslearning.todoservice.services.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository repository;

	@Override
	public Item findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Item> findByCategoryId(long categoryId) {
		return repository.findByCategoryId(categoryId).orElse(null);
	}

	@Override
	public Item saveOrUpdate(Item todoNote) {
		return repository.save(todoNote);
	}

	@Override
	public void delete(Item todoNote) {
		repository.delete(todoNote);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
