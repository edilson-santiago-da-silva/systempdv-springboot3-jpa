package com.system.pdv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.pdv.entities.UserSys;
import com.system.pdv.services.UserSysService;

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
}
