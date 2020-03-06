package com.ctl.todoservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctl.todoservice.model.TODOItem;
import com.ctl.todoservice.repository.TODORepository;
import com.ctl.todoservice.services.TODOService;

@Service
public class TODOServiceImpl implements TODOService {
	
	@Autowired
	private TODORepository repository;

	@Override
	public TODOItem findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<TODOItem> findByCreatedBy(String createdBy) {
		return repository.findByCreatedBy(createdBy).orElse(null);
	}

	@Override
	public TODOItem saveOrUpdate(TODOItem item) {
		return repository.save(item);
	}

	@Override
	public void delete(TODOItem item) {
		repository.delete(item);
	}
	
	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

}
