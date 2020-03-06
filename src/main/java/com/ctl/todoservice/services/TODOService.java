package com.ctl.todoservice.services;

import java.util.List;

import com.ctl.todoservice.model.TODOItem;

public interface TODOService {
	
	public TODOItem findById(long id);
	
	public List<TODOItem> findByCreatedBy(String createdBy);
	
	public TODOItem saveOrUpdate(TODOItem item);
	
	public void delete(TODOItem item);
	
	public void deleteById(long id);

}
