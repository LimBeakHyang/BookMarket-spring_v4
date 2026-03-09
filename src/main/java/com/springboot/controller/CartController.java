package com.springboot.controller;

// 스프링이 관리하는 객체를 자동으로 주입받기 위한 어노테이션
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// 현재 클래스를 스프링 MVC 컨트롤러로 등록하기 위한 어노테이션
import org.springframework.stereotype.Controller;

// 컨트롤러에서 뷰(View)로 데이터를 전달할 때 사용하는 객체
import org.springframework.ui.Model;

// HTTP GET 요청을 처리하기 위한 어노테이션
import org.springframework.web.bind.annotation.GetMapping;

// URL 경로에 포함된 값을 메서드 매개변수로 받기 위한 어노테이션
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// HTTP PUT 요청을 처리하기 위한 어노테이션
import org.springframework.web.bind.annotation.PutMapping;

// 요청 본문(body)에 담긴 데이터를 객체로 받기 위한 어노테이션
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// 반환값을 뷰가 아니라 HTTP 응답 본문으로 바로 보내기 위한 어노테이션
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.springboot.domain.Book;
// 장바구니 도메인 클래스 import
import com.springboot.domain.Cart;
import com.springboot.domain.CartItem;
import com.springboot.service.BookService;
// 장바구니 서비스 인터페이스 import
import com.springboot.service.CartService;

import jakarta.servlet.http.HttpServletRequest;

import com.springboot.exception.BookIdException;

// 이 클래스가 컨트롤러 역할을 하는 스프링 MVC 컨트롤러임을 표시
@Controller
@RequestMapping(value = "/cart")
public class CartController {
	
	// CartService 구현체를 스프링이 자동으로 주입함
	@Autowired
	private CartService cartService;
	
	
	
	@GetMapping
	public String requestCartId(HttpServletRequest request) {
		System.out.println("aaaa");
		String sessionid = request.getSession(true).getId();
		return "redirect:/cart/"+ sessionid;
	}
	
	// 장바구니 생성 요청 처리
	// 요청 본문에 담긴 Cart 객체를 받아 서비스에 전달한 뒤
	// 생성된 Cart 객체를 응답 본문으로 그대로 반환
	@PostMapping
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
	
	@Autowired
	private BookService bookService;
	@PutMapping("/{cartId}")
	public @ResponseBody Cart read(@PathVariable(value = "cartId") String cartId) {
		System.out.println("dddd");
		return cartService.read(cartId);
	}
	
	@PutMapping("/book/{bookId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT) // 오류 응답 상태 코드 설정
	public void addCartByNewItem(@PathVariable("bookId") String bookId,
			HttpServletRequest request) {
		
		String sessionId = request.getSession(true).getId(); // 장바구니 ID 가져오기
		Cart cart = cartService.read(sessionId); // 장바구니 내 모든 정보 가져오기
		if(cart == null) {
			cart = cartService.create(new Cart(sessionId));
	}
		Book book = bookService.getBookById(bookId); // booId 정보 가져오기
		if(book == null) {
			throw new IllegalArgumentException(new BookIdException(bookId));
	}
		cart.addCartItem(new CartItem(book)); // 장바구니에 bookId 도서 등록하기
		cartService.update(sessionId, cart); // 장바구니 갱신하기
		}
			
		
		
	}
