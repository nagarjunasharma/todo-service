package com.nslearning.todoservice.services;

import java.util.List;

import com.nslearning.todoservice.model.Item;

public interface ItemService {

	public Item findById(long id);
	
	public List<Item> findByCategoryId(long todoId);
	
	public Item saveOrUpdate(Item item);
	
	public void delete(Item item);
	
	public void deleteById(long id);

}
