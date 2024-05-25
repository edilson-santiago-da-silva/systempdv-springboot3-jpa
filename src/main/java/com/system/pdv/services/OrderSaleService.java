package com.system.pdv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.pdv.entities.OrderSale;
import com.system.pdv.repositores.OrderSaleRepository;

@Service
public class OrderSaleService {

	@Autowired
	private OrderSaleRepository repository;
	
	public List<OrderSale> findAll(){
		return repository.findAll();
	}
	
	public OrderSale findById(Integer id) {
		Optional<OrderSale> obj = repository.findById(id);
		return obj.get();
	}
	
	public OrderSale insert(OrderSale obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public OrderSale update(Integer id, OrderSale obj) {
		OrderSale entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(OrderSale entity, OrderSale obj) {
		entity.setPayment(obj.getPayment());
	}
}
