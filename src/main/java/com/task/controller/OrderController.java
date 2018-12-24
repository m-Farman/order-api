package com.task.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.task.entity.Order;
import com.task.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping(method = RequestMethod.POST, value = "/create/{userId}/{productId}")
	public ResponseEntity<?> createOrder(@NonNull @PathVariable Long userId, @NonNull @PathVariable Long productId) {
		Order order=orderService.createOrder(userId, productId);
		if (Objects.isNull(order)) {
			return new ResponseEntity<String>("Failed to create order", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
	}

}
