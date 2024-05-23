package com.system.pdv.services;



import java.util.List;

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
}
