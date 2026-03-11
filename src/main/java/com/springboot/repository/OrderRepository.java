package com.springboot.repository;

import com.springboot.domain.Order;

public interface OrderRepository {
	Long saveOrder(Order order); // 주문 목록 저장 메서드
}
