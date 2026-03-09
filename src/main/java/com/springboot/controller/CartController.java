package com.springboot.controller;

// 스프링이 관리하는 객체를 자동으로 주입받기 위한 어노테이션
import org.springframework.beans.factory.annotation.Autowired;

// 현재 클래스를 스프링 MVC 컨트롤러로 등록하기 위한 어노테이션
import org.springframework.stereotype.Controller;

// 컨트롤러에서 뷰(View)로 데이터를 전달할 때 사용하는 객체
import org.springframework.ui.Model;

// HTTP GET 요청을 처리하기 위한 어노테이션
import org.springframework.web.bind.annotation.GetMapping;

// URL 경로에 포함된 값을 메서드 매개변수로 받기 위한 어노테이션
import org.springframework.web.bind.annotation.PathVariable;

// HTTP PUT 요청을 처리하기 위한 어노테이션
import org.springframework.web.bind.annotation.PutMapping;

// 요청 본문(body)에 담긴 데이터를 객체로 받기 위한 어노테이션
import org.springframework.web.bind.annotation.RequestBody;

// 반환값을 뷰가 아니라 HTTP 응답 본문으로 바로 보내기 위한 어노테이션
import org.springframework.web.bind.annotation.ResponseBody;

// 장바구니 도메인 클래스 import
import com.springboot.domain.Cart;

// 장바구니 서비스 인터페이스 import
import com.springboot.service.CartService;

// 이 클래스가 컨트롤러 역할을 하는 스프링 MVC 컨트롤러임을 표시
@Controller
public class CartController {
	
	// CartService 구현체를 스프링이 자동으로 주입함
	@Autowired
	private CartService cartService;
	
	// 장바구니 생성 요청 처리
	// 요청 본문에 담긴 Cart 객체를 받아 서비스에 전달한 뒤
	// 생성된 Cart 객체를 응답 본문으로 그대로 반환
	@GetMapping
	public @ResponseBody Cart create(@RequestBody Cart cart) {
		System.out.println("bbb");
		return cartService.create(cart);
	}
	
	// 장바구니 ID를 이용해 장바구니 정보를 조회하고
	// 조회한 결과를 Model에 담아 cart.jsp 또는 cart.html 같은 뷰로 전달
	@GetMapping("/{cartId}")
	public String requestCartList(@PathVariable(value = "cartId") String cartId, Model model) {
		System.out.println("cccc");
		
		// cartId에 해당하는 장바구니를 서비스에서 조회
		Cart cart = cartService.read(cartId);
		
		// 조회한 장바구니 객체를 model에 담아서 뷰에 전달
		model.addAttribute("cart", cart);
		
		// cart라는 이름의 뷰 페이지로 이동
		return "cart";
	}
	
	// 장바구니 ID를 이용해 장바구니를 조회한 후
	// 조회 결과를 JSON 형태 등으로 응답 본문에 직접 반환
	@PutMapping("/{cartId}")
	public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
		System.out.println("dddd");
		return cartService.read(cartId);
	}
}