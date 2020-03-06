package com.ctl.todoservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctl.todoservice.model.TODOItem;

@Repository
public interface TODORepository extends JpaRepository<TODOItem, Long> {
	
	public Optional<List<TODOItem>> findByCreatedBy(String createdBy); 

}
