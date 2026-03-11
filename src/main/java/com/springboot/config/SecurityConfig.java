package com.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	protected UserDetailsService users() {
		UserDetails admin = User.builder()
				.username("Admin")
				.password(passwordEncoder().encode("Admin1234"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(admin);
	}
	
	@Bean
	protected SecurityFilterChain examMethod04(HttpSecurity http) throws Exception{
		http
		.csrf(AbstractHttpConfigurer::disable)
		.authorizeHttpRequests(
				authorizeRequests -> authorizeRequests
				.requestMatchers("/books/add").hasRole("ADMIN")
				.anyRequest().permitAll()	
				)
		/* Spring Security 기본 로그인 페이지 사용할때
		 *.formLogin(Customizer.withDefaults()); */
		
		// 개발자가 기본 로그인 페이지 만들어서 사용할때
		.formLogin(
				formLogin -> formLogin
				.loginPage("/login") // 로그인 페이지의 경로
				.loginProcessingUrl("/login") // 로그인 페이지의 경로
				.defaultSuccessUrl("/books/add") // 인증에 성공할 때의 경로
				.failureUrl("/loginfailed") // 인정에 실패할 때의 경로
				.usernameParameter("username") // 사용자 이름(계정)
				.passwordParameter("password") //사용자 계정 비밀번호
				.permitAll()	
				) 
		// 로그아웃 기능 구현
		.logout(
				logout -> logout
				.logoutUrl("/logout") // /logout으로 로그아웃 페이지 호출
				.logoutSuccessUrl("/login") // 로그아웃에 성공하면 /login으로 자동 이동
		);
		
		return http.build();
		}
	} 
