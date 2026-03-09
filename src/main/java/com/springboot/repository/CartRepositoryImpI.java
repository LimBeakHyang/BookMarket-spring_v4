package com.springboot.repository;

// Map 구현체로 key-value 형태의 데이터를 저장하기 위해 사용
import java.util.HashMap;
import java.util.Map;

// 현재 클래스를 스프링의 Repository 빈으로 등록하기 위한 어노테이션
import org.springframework.stereotype.Repository;

// Cart 도메인 클래스를 사용하기 위해 import
import com.springboot.domain.Cart;

// 이 클래스가 장바구니 저장소 역할을 하는 Repository 클래스임을 표시
@Repository
public class CartRepositoryImpI implements CartRepository {
	
	// 장바구니들을 저장하는 Map
	// key   : 장바구니 ID
	// value : Cart 객체
	private Map<String, Cart> listOfCartsMap;
	
	// 생성자
	// Repository 객체가 생성될 때 장바구니 저장소(Map)를 초기화함
	public CartRepositoryImpI() {
		listOfCartsMap = new HashMap<String, Cart>();
	}
	
	// 장바구니를 생성하여 저장하는 메서드
	public Cart create(Cart cart) {
		
		// 이미 같은 장바구니 ID가 존재하는지 확인
		if (listOfCartsMap.keySet().contains(cart.getCartId())) {
			
			// 같은 ID가 이미 있으면 예외 발생
			throw new IllegalArgumentException(
				String.format("장바구니를 생성할 수 없습니다. 장바구니 id(%)가 존재합니다", cart.getCartId())
			);
		}
		
		// Map에 장바구니 ID를 key로, Cart 객체를 value로 저장
		listOfCartsMap.put(cart.getCartId(), cart);
		
		// 저장한 장바구니 객체 반환
		return cart;
	}
	
	// 장바구니 ID를 이용해 장바구니를 조회하는 메서드
	public Cart read(String cartId) {
		
		// Map에서 해당 cartId에 해당하는 Cart 객체를 반환
		return listOfCartsMap.get(cartId);
	}
}