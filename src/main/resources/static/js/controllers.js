function addToCart(bookId){
	if(confirm("장바구니에 도서를 추가합니까?") == true){
		document.addForm.action = "/bookmarket/cart/book/" + bookId;
		document.addForm.submit();
	}
}