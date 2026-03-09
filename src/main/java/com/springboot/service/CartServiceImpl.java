package com.springboot.service;

// 스프링이 관리하는 객체를 자동으로 주입받기 위해 사용하는 어노테이션
import org.springframework.beans.factory.annotation.Autowired;

// 현재 클래스를 서비스 계층의 Bean으로 등록하기 위한 어노테이션
import org.springframework.stereotype.Service;

// 장바구니 도메인 클래스 import
import com.springboot.domain.Cart;

// 장바구니 저장소(Repository) 인터페이스 import
import com.springboot.repository.CartRepository;

// 이 클래스가 서비스 역할을 하는 스프링 Bean임을 표시
@Service
public class CartServiceImpl implements CartService {
	
	// CartRepository 타입의 객체를 스프링이 자동으로 주입함
	@Autowired
	private CartRepository cartRepository;
	
	// 장바구니 생성 기능
	@Override
	public Cart create(Cart cart) {
		// 전달받은 Cart 객체를 Repository에 저장하도록 요청
		return cartRepository.create(cart);
	}

	// 장바구니 조회 기능
	@Override
	public Cart read(String cartId) {
		// 전달받은 cartId를 이용해서 Repository에서 장바구니 조회
		return cartRepository.read(cartId);
	}
}