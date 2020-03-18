package com.nslearning.todoservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nslearning.todoservice.model.TODOItem;

@Repository
public interface TODORepository extends JpaRepository<TODOItem, Long> {
	
	public Optional<List<TODOItem>> findByUserId(long userId); 

}
