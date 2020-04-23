package com.nslearning.todoservice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nslearning.todoservice.model.Category;
import com.nslearning.todoservice.model.Constants;
import com.nslearning.todoservice.services.CategoryService;

@RestController
@RequestMapping(value = "/todo/category")
public class CategoryResource {

	@Autowired
	private CategoryService todoService;

	@GetMapping("/{id}")
	@PreAuthorize(Constants.USER_ROLE)
	public ResponseEntity<Category> findById(@PathVariable("id") long id) {
		Category todoItems = todoService.findById(id);
		return (todoItems != null ? new ResponseEntity<Category>(todoItems, HttpStatus.OK)
				: new ResponseEntity<Category>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/user/{userId}")
	@PreAuthorize(Constants.USER_ROLE)
	public ResponseEntity<List<Category>> findByUser(@PathVariable("userId") long userId) {
		List<Category> todoItems = todoService.findByUserId(userId);
		return (todoItems != null ? new ResponseEntity<List<Category>>(todoItems, HttpStatus.OK)
				: new ResponseEntity<List<Category>>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	@PreAuthorize(Constants.USER_ROLE)
	public ResponseEntity<Category> save(@RequestBody Category item) {
		return new ResponseEntity<>(todoService.saveOrUpdate(item), HttpStatus.OK);
	}

	@PutMapping
	@PreAuthorize(Constants.USER_ROLE)
	public ResponseEntity<Category> update(@RequestBody Category item) {
		return save(item);
	}

	@DeleteMapping
	@PreAuthorize(Constants.USER_ROLE)
	public void delete(@RequestBody Category item) {
		todoService.delete(item);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize(Constants.USER_ROLE)
	public void deleteById(@PathVariable("id") long id) {
		todoService.deleteById(id);
	}


}
