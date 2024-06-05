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

import com.system.pdv.entities.OrderSale;
import com.system.pdv.services.OrderSaleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/orders")
@Tag(name = "orders")
public class OrderSaleResource {
	
	@Autowired
	private OrderSaleService service;
	
	@GetMapping
	@Operation(summary = "Search all orders", description = "Search all registered orders")
    @ApiResponse(responseCode = "200", description = "OK (Successful operation)")
	public ResponseEntity<List<OrderSale>> findAll() {
		List<OrderSale> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Find orders by id", description = "Search an order based on your id")
    @ApiResponse(responseCode = "200", description = "OK (Successful operation)")
	public ResponseEntity<OrderSale> findById(@PathVariable Integer id) {
		OrderSale obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@PostMapping
	@Operation(summary = "Add new orders", description = "Add new order")
    @ApiResponse(responseCode = "201", description = "Created (Successful operation)")
	public ResponseEntity<OrderSale> insert(@RequestBody OrderSale obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Delete orders by id", description = "Delete an order based on your id")
    @ApiResponse(responseCode = "204", description = "No content (Successful operation)")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@Transactional
	@PutMapping(value = "/{id}")
	@Operation(summary = "Update orders by id", description = "Alert! Only PAYMENT can be changed due to business rules")
    @ApiResponse(responseCode = "200", description = "OK (Successful operation)")
	public ResponseEntity<OrderSale> update(@PathVariable Integer id, @RequestBody OrderSale obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
