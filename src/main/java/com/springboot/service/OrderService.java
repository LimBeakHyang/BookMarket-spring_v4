package com.springboot.service;

import com.springboot.domain.Order;

public interface OrderService {
	void confirmOrder(String bookId, long quantity); // 도서 재고 수 처리 메서드
	Long saveOrder(Order order);  // 주문 목록 저장 메서드
}
