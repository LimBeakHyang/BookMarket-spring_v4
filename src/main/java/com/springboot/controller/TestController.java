package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 반드시 이 어노테이션이 있어야 브라우저가 찾을 수 있습니다!
public class TestController {

    @GetMapping("/test")
    public String testPage() {
        // 이 리턴값은 src/main/resources/templates/test.html 파일을 의미합니다.
        return "module/header"; 
    }
    
    @GetMapping("/test_2")
    public String testPage_2() {
        // 이 리턴값은 src/main/resources/templates/test.html 파일을 의미합니다.
        return "module/footer"; 
    }
}