package com.orders.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.orders.app.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
