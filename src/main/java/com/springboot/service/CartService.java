package com.springboot.service;

// 장바구니 도메인 클래스(Cart)를 사용하기 위해 import
import com.springboot.domain.Cart;

// 장바구니 관련 서비스 기능을 정의하는 인터페이스
public interface CartService {

	// 장바구니를 생성하는 메서드
	// Cart 객체를 전달받아 생성(또는 저장)한 뒤
	// 생성된 Cart 객체를 반환함
	Cart create(Cart cart);

	// 장바구니 ID를 이용해 장바구니를 조회하는 메서드
	// cartId에 해당하는 Cart 객체를 반환함
	Cart read(String cartId);

	// 장바구니 ID(cartId)에 해당하는 장바구니 정보를 전달받은 Cart 객체 내용으로 수정하는 메서드
	void update(String cartId, Cart cart);
}