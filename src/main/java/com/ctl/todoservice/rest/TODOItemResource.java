package com.ctl.todoservice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctl.todoservice.model.TODOItem;
import com.ctl.todoservice.services.TODOService;

@RestController
@RequestMapping(value = "/todo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TODOItemResource {

	@Autowired
	private TODOService todoService;

	@GetMapping("/{id}")
	public ResponseEntity<TODOItem> findById(@PathVariable("id") long id) {
		TODOItem todoItems = todoService.findById(id);
		return (todoItems != null ? new ResponseEntity<TODOItem>(todoItems, HttpStatus.OK)
				: new ResponseEntity<TODOItem>(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/user/{name}")
	public ResponseEntity<List<TODOItem>> findByUser(@PathVariable("name") String username) {
		List<TODOItem> todoItems = todoService.findByCreatedBy(username);
		return (todoItems != null ? new ResponseEntity<List<TODOItem>>(todoItems, HttpStatus.OK)
				: new ResponseEntity<List<TODOItem>>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<TODOItem> save(@RequestBody TODOItem item) {
		return new ResponseEntity<TODOItem>(todoService.saveOrUpdate(item), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<TODOItem> update(@RequestBody TODOItem item) {
		return save(item);
	}

	@DeleteMapping
	public void delete(@RequestBody TODOItem item) {
		todoService.delete(item);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") long id) {
		todoService.deleteById(id);
	}


}
