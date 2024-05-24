package com.system.pdv.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.pdv.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
