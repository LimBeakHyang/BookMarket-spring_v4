package com.springboot.domain;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	private Long id; // 아이디(테이블의 기본 키)
	private String bookId; // 주문 도서 아이디
	private int quantity; // 주문 도서 수량
	private BigDecimal totalPrice; // 주문 도서 총 가격
}
