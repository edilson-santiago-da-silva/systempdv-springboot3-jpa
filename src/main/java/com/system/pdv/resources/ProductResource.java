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

import com.system.pdv.entities.Product;
import com.system.pdv.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "products")
public class ProductResource {

	@Autowired
	private ProductService service;
	
	@GetMapping
	@Operation(summary = "Search all products", description = "Search all registered products")
    @ApiResponse(responseCode = "200", description = "OK (Successful operation)")
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Find products by id", description = "Search an product based on your id")
    @ApiResponse(responseCode = "200", description = "OK (Successful operation)")
	public ResponseEntity<Product> findById(@PathVariable Integer id) {
		Product obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	@Operation(summary = "Add new products", description = "Add new product")
    @ApiResponse(responseCode = "201", description = "Created (Successful operation)")
	public ResponseEntity<Product> insert(@RequestBody Product obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete products by id", description = "Delete an product based on your id")
    @ApiResponse(responseCode = "204", description = "No content (Successful operation)")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@Transactional
	@PutMapping(value = "/{id}")
	@Operation(summary = "Update products by id", description = "Update an Product based on your id")
    @ApiResponse(responseCode = "200", description = "OK (Successful operation)")
	public ResponseEntity<Product> update(@PathVariable Integer id, @RequestBody Product obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
