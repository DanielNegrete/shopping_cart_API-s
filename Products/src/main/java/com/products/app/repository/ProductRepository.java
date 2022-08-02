package com.products.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.products.app.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
