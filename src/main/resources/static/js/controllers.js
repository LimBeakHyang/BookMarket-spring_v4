function addToCart(bookId){
	if(confirm("장바구니에 도서를 추가합니까?") == true){
		document.addForm.action = "/bookmarket/cart/book/" + bookId;
		document.addForm.submit();
	}
}

function removeFromCart(bookid, cartId){ // 장바구니에 등록된 도서 항목을 삭제하는 메서드
	document.removeForm.action = "/bookmarket/cart/book/"+bookid;
	document.removeForm.submit();
	setTimeout('location.reload()',10);
}