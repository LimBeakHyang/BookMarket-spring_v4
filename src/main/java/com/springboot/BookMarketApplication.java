package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.domain.Member;
import com.springboot.domain.Role;
import com.springboot.service.MemberService;

@SpringBootApplication
public class BookMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMarketApplication.class, args);
    }

    // 관리자 정보를 Member 엔티티에 등록
    @Bean
    public CommandLineRunner run(MemberService memberService) throws Exception {
        return (String[] args) -> {
            Member member = new Member();
            member.setMemberId("Admin");
            member.setName("관리자");
            member.setPhone("");
            member.setEmail("");
            member.setAddress("");
            
         // 🔥 여기에 나이 설정 코드를 추가해 주세요! (숫자만 입력)
            member.setAge(20);

            // BCrypt를 사용하여 비밀번호 암호화
            String password = new BCryptPasswordEncoder().encode("Admin1234");
            member.setPassword(password);

            // 권한을 ADMIN으로 설정
            member.setRole(Role.ADMIN);

            // 서비스 계층을 통해 회원 정보 저장
           // memberService.saveMember(member);
        };
    }
}