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

import com.nslearning.todoservice.model.Constants;
import com.nslearning.todoservice.model.Item;
import com.nslearning.todoservice.services.ItemService;

@RestController
@RequestMapping(value = "/todo/item")
public class ItemResource {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/{id}")
	@PreAuthorize(Constants.USER_ROLE)
	public ResponseEntity<Item> findById(@PathVariable("id") long id) {
		Item todoNote = itemService.findById(id);
		return (todoNote != null ?  new ResponseEntity<>(todoNote, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@GetMapping("/{categoryId}")
	@PreAuthorize(Constants.USER_ROLE)
	public ResponseEntity<List<Item>> findByCategoryId(@PathVariable("todoId") long todoId){
		List<Item> todoNotes = itemService.findByCategoryId(todoId);
		return ( todoNotes != null ? new ResponseEntity<>(todoNotes,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping
	@PreAuthorize(Constants.USER_ROLE)
	public ResponseEntity<Item> save(@RequestBody Item item) {
		Item savedItem = itemService.saveOrUpdate(item);
		return (savedItem != null ?  new ResponseEntity<>(savedItem, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping
	@PreAuthorize(Constants.USER_ROLE)
	public ResponseEntity<Item> update(@RequestBody Item item) {
		return save(item);
	}
	
	@DeleteMapping
	@PreAuthorize(Constants.USER_ROLE)
	public void delete(@RequestBody Item item) {
		itemService.delete(item);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize(Constants.USER_ROLE)
	public void deleteById(@PathVariable("id") long id) {
		itemService.deleteById(id);
	}

}
