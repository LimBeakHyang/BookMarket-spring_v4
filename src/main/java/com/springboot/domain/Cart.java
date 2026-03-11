package com.springboot.domain;

// 금액 계산을 정확하게 처리하기 위한 클래스
import java.math.BigDecimal;

// key-value 형태로 데이터를 저장하기 위한 컬렉션 인터페이스
import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.ToString;

// Lombok 기능
// @Data : getter, setter, equals, hashCode, toString 등을 자동 생성
@Data
@ToString
public class Cart {

	// 장바구니 고유 ID
	private String cartId;

	// 장바구니에 담긴 항목들을 저장하는 Map
	// key : 도서 ID(String)
	// value : 장바구니 항목(CartItem)
	private Map<String, CartItem> cartItems;

	// 장바구니에 담긴 전체 금액
	public BigDecimal grandTotal;

	// 기본 생성자
	public Cart() {
		// 장바구니 항목들을 저장할 HashMap 객체 생성
		cartItems = new HashMap<String, CartItem>();

		// 처음 장바구니를 만들 때 총액은 0으로 초기화
		grandTotal = new BigDecimal(0);
	}

	// 장바구니 ID를 받아서 생성하는 생성자
	public Cart(String cartId) {
		// 기본 생성자를 먼저 호출하여
		// cartItems와 grandTotal을 초기화함
		this();

		// 전달받은 cartId를 장바구니 ID로 저장
		this.cartId = cartId;
	}

	public void addCartItem(CartItem item) {
		String bookId = item.getBook().getBookId();
		if (cartItems.containsKey(bookId)) {
			CartItem cartItem = cartItems.get(bookId);
			cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
			cartItems.put(bookId, cartItem);
		} else {
			cartItems.put(bookId, item);
		}
		updateGrandTotal(); // 총액 갱신
	}

	private void updateGrandTotal() {
		grandTotal = new BigDecimal(0);

		for (CartItem item : cartItems.values()) {
			grandTotal = grandTotal.add(item.getTotalPrice());
		}
	}
	/*//booId로 삭제하기
	public void removeCartItem(String bookId) {
	    cartItems.remove(bookId);  // bookId로 해당 아이템 삭제
	    updateGrandTotal();  // 총액 갱신 
	}*/
	
	
	public void removeCartItem(CartItem item) {
		String bookId = item.getBook().getBookId();
		cartItems.remove(bookId); // BookId의 도서 삭제
		updateGrandTotal(); // 총액 갱신
	} 

}