package com.nslearning.todoservice.services;

import java.util.List;

import com.nslearning.todoservice.model.TODOItem;

public interface TODOService {
	
	public TODOItem findById(long id);
	
	public List<TODOItem> findByUserId(long userId);
	
	public TODOItem saveOrUpdate(TODOItem item);
	
	public void delete(TODOItem item);
	
	public void deleteById(long id);

}
