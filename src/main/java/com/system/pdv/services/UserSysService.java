package com.system.pdv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.pdv.entities.UserSys;
import com.system.pdv.repositores.UserSysRepository;

@Service
public class UserSysService {

	@Autowired
	private UserSysRepository repository;
	
	public List<UserSys> findAll(){
		return  repository.findAll();
	}
	
	public UserSys findById(Integer id) {
		Optional<UserSys> obj = repository.findById(id);
		return obj.get();
	}
	
	public UserSys insert(UserSys obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public UserSys update(Integer id, UserSys obj) {
		UserSys entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(UserSys entity, UserSys obj) {
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
	}
}
