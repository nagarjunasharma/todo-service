package com.nslearning.todoservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nslearning.todoservice.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	public Optional<List<Category>> findByUserId(long userId); 

}
