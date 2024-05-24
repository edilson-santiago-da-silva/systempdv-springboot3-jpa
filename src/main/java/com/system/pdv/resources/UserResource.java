package com.system.pdv.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.system.pdv.entities.UserSys;
import com.system.pdv.services.UserSysService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserSysService service;

	@GetMapping
	public ResponseEntity<List<UserSys>> findAll() {
		List<UserSys> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserSys> findById(@PathVariable Integer id) {
		UserSys obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@PostMapping
	public ResponseEntity<UserSys> insert(@RequestBody UserSys obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@Transactional
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserSys> update(@PathVariable Integer id, @RequestBody UserSys obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
