package com.system.pdv.resources;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.pdv.entities.Usersys;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa"); // Responsável por criar e gerenciar instâncias de EntityManager
	EntityManager em = emf.createEntityManager(); // realiza operações de CRUD (Create, Read, Update, Delete) no banco de dados
	
	@GetMapping
	public ResponseEntity<Usersys> findAll(){
		Usersys user = em.find(Usersys.class, 2);
		return ResponseEntity.ok().body(user);
	}
}
