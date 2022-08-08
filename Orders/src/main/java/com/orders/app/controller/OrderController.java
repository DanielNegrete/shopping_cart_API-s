package com.orders.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.orders.app.dto.OrderRequestDTO;
import com.orders.app.dto.ResponseDTO;
import com.orders.app.entity.ShoppingOrder;
import com.orders.app.repository.OrderRepository;

@Controller
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping(path="/orders")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PostMapping(path="/add")
	public ResponseEntity<ResponseDTO> addOrder(@RequestBody OrderRequestDTO orderRequestDTO){
		ShoppingOrder order = new ShoppingOrder();
		
		order.setUsername(orderRequestDTO.getUsername());
		order.setDate(orderRequestDTO.getDate());
		order.setCountry(orderRequestDTO.getCountry());
		order.setFirstName(orderRequestDTO.getFirstName());
		order.setLastName(orderRequestDTO.getLastName());
		order.setAddress(orderRequestDTO.getAddress());
		order.setApartment(orderRequestDTO.getApartment());
		order.setCity(orderRequestDTO.getCity());
		order.setPostalCode(orderRequestDTO.getPostalCode());
		order.setPhoneNumber(orderRequestDTO.getPhoneNumber());
		order.setCart(orderRequestDTO.getCart());
		order.setCoupon(orderRequestDTO.getCoupon());
		order.setTotalPrice(orderRequestDTO.getTotalPrice());
		orderRepository.save(order);
		ResponseDTO responseDTO = new ResponseDTO("Order added", 200);
		
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<ShoppingOrder> getAllOrders(){
		return orderRepository.findAll();
	}

}
