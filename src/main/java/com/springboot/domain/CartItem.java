package com.springboot.domain;

// 큰 금액 계산에서 정확한 값을 다루기 위해 사용하는 클래스
// int, double보다 금액 계산에 더 적합함
import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;

// 객체 내용을 문자열로 출력할 때 자동으로 toString() 메서드를 만들어줌
@ToString
public class CartItem {
	
	// 장바구니에 담긴 도서 정보
	private Book book;
	
	// 장바구니에 담긴 도서 수량
	private int quantity;
	
	// 해당 도서의 총 금액
	// 1권 가격 × 수량으로 계산됨
	private BigDecimal totalPriceBigDecimal;
	
	// 생성자
	// CartItem 객체를 만들 때 어떤 도서를 담을지 전달받음
	public CartItem(Book book) {
		super();
		
		// 전달받은 도서 객체를 현재 장바구니 항목의 도서로 저장
		this.book = book;
		
		// 장바구니에 처음 담을 때 기본 수량을 1로 설정
		this.quantity = 1;
		
		// 처음 담을 때 총 금액은 도서 1권 가격과 같으므로
		// book의 가격을 totalPriceBigDecimal에 저장
		this.totalPriceBigDecimal = book.getUnitPrice();
	}
	
	// 도서 정보를 변경하는 setter 메서드
	public void setBook(Book book) {
		// 새로운 도서로 변경
		this.book = book;
		
		// 도서가 바뀌면 가격도 달라질 수 있으므로 총 금액 다시 계산
		this.updateTotalPrice();
	}
	
	// 수량을 변경하는 setter 메서드
	public void setQuantity(int quantity) {
		// 수량 변경
		this.quantity = quantity;
		
		// 수량이 바뀌면 총 금액도 바뀌므로 다시 계산
		this.updateTotalPrice();
	}
	
	// 총 금액을 다시 계산하는 메서드
	public void updateTotalPrice() {
		// 도서 1권 가격(book.getUnitPrice())에 수량(quantity)을 곱해서
		// 총 금액을 계산한 후 totalPriceBigDecimal에 저장
		totalPriceBigDecimal = this.book.getUnitPrice().multiply(new BigDecimal(this.quantity));
	}
}