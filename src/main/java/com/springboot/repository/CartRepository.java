package com.springboot.repository;

// 장바구니(Cart) 도메인 클래스를 사용하기 위해 import
import com.springboot.domain.Cart;

// 장바구니 관련 데이터 처리 기능을 정의하는 인터페이스
public interface CartRepository {
	
	// 장바구니를 생성(저장)하는 메서드
	Cart create(Cart cart);
	
	// cartId를 이용해서 장바구니를 조회하는 메서드
	Cart read(String cartId);
	void update(String cartId, Cart cart);
	
	void delete(String cartId);
}