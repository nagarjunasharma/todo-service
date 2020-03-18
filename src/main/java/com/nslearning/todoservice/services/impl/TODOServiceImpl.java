package com.nslearning.todoservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nslearning.todoservice.model.TODOItem;
import com.nslearning.todoservice.repository.TODORepository;
import com.nslearning.todoservice.services.TODOService;

@Service
public class TODOServiceImpl implements TODOService {
	
	@Autowired
	private TODORepository repository;

	@Override
	public TODOItem findById(long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<TODOItem> findByUserId(long userId) {
		return repository.findByUserId(userId).orElse(null);
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
