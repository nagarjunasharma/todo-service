package com.nslearning.todoservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nslearning.todoservice.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	public Optional<List<Item>> findByCategoryId(long categoryId);
 
}
