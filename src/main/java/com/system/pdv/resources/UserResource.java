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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/users")
@Tag(name = "users")
public class UserResource {

	@Autowired
	private UserSysService service;

	@GetMapping
	@Operation(summary = "Search all users", description = "Search all registered users")
    @ApiResponse(responseCode = "200", description = "OK (Successful operation)")
	public ResponseEntity<List<UserSys>> findAll() {
		List<UserSys> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Find users by id", description = "Search an user based on your id")
    @ApiResponse(responseCode = "200", description = "OK (Successful operation)")
	public ResponseEntity<UserSys> findById(@PathVariable Integer id) {
		UserSys obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}

	@PostMapping
	@Operation(summary = "Add new users", description = "Add new user")
    @ApiResponse(responseCode = "201", description = "Created (Successful operation)")
	public ResponseEntity<UserSys> insert(@RequestBody UserSys obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete users by id", description = "Delete an user based on your id")
    @ApiResponse(responseCode = "204", description = "No content (Successful operation)")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@Transactional
	@PutMapping(value = "/{id}")
	@Operation(summary = "Update users by id", description = "Update an Product based on your id")
    @ApiResponse(responseCode = "200", description = "OK (Successful operation)")
	public ResponseEntity<UserSys> update(@PathVariable Integer id, @RequestBody UserSys obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
