package com.springboot.controller;

// 특정 URL 요청을 처리하기 위한 어노테이션 import
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 이 클래스가 REST 방식의 컨트롤러임을 나타내는 어노테이션
// 반환값을 뷰 이름이 아니라 응답 본문(body)으로 직접 보냄
import org.springframework.web.bind.annotation.RestController;

// 이 클래스가 컨트롤러 역할을 하는 클래스임을 나타냄
@RestController
public class WelcomeController {

   // "/home" 주소로 GET 요청이 들어오면 이 메서드가 실행됨
   @RequestMapping(value = "/home", method = RequestMethod.GET)
   public String welcomeMethod() {
	   
	     // 브라우저에 그대로 출력할 HTML 문자열을 저장하는 변수
	     String outHtml =
			   "<html> "+
			   "<head> "+ 
			   "	<meta charset='UTF-8'> "+ // 한글 깨짐 방지를 위한 문자 인코딩 설정
			   "	<title>Welcome</title> "+ // 브라우저 탭 제목
			   "	<link href='https://getbootstrap.com/docs/5.3/dist/css/bootstrap.min.css' rel='stylesheet'>"+ // 부트스트랩 CSS 연결
			   "</head>"+
			   
			   " <body>"+
			   
			   // 전체 화면을 감싸는 컨테이너
			   " <div class='container py-4'>"+
			   
			   // 상단 헤더 영역
			   " 	<header class='pb-3 mb-4 border-bottom'>  "+
			   
			   // 로고를 누르면 ./home 으로 이동
			   " 		<a href='./home' class='d-flex align-items-center text-body-emphasis text-decoration-none'>"+
			   
			   // 책 아이콘 SVG
			   " 			<svg xmlns='http://www.w3.org/2000/svg' width='32' height='32' fill='currentColor' class='bi bi-book-half me-2' viewBox='0 0 16 16'>"+
			   "				<path d='M8.5 2.687c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783'/>"+
			   "			</svg>"+
			   
			   // 로고 옆에 표시할 사이트 이름
			   "			<span class='fs-4'>BookMarket</span>"+
			   " 		</a>"+
			   " 	</header>"+

			   // 메인 환영 문구 영역
			   " 	<div class='p-5 mb-4 bg-body-tertiary rounded-3'>"+
			   "  		<div class='container-fluid py-5'>"+
			   "			<h1 class='display-5 fw-bold'>도서 쇼핑몰에 오신 것을 환영합니다</h1>"+
			   " 			<p class='col-md-8 fs-4'>BookMarket</p>       "+
			   " 		</div>"+
			   "	</div>"+

			   // 가운데 본문 영역
			   "  	<div class='row align-items-md-stretch text-center'>"+
			   "   		<div class='col-md-12'>"+
			   "   			<div class='h-100 p-5'>"+
			   "   				<h2>Welcome to Web Market!</h2>"+
			   "            	</div>"+
			   "   		</div>"+
			   "       </div>"+
			     
			   // 하단 푸터 영역
			   "  	<footer class='pt-3 mt-4 text-body-secondary border-top'>"+
			   "    		<span class='text-body-secondary'> &copy; BookMarket</span>"+
			   "  	</footer>"+
			   "  </div>"+
			   "  </body>"+
			   "  </html>";
	     
	     // 완성된 HTML 문자열을 브라우저에 그대로 반환
         return outHtml; 
   }
}