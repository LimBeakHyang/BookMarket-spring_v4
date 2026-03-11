package com.springboot.domain;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class Shipping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // 아이디
	private String name; // 배송 고객 이름
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private String date; // 배송일
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address; // 배송 주소 객체
}
