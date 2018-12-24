package com.task.service;

import com.task.entity.Order;

public interface OrderService {

	Order createOrder(Long userId, Long productId);
}
