package com.orders.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.orders.app.entity.ShoppingOrder;

public interface OrderRepository extends CrudRepository<ShoppingOrder, Integer>{

}
