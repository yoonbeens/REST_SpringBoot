package com.example.demo.data.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class VipUser {

	@Id
	private Integer userId;
	private String userName;
	private Integer userAge;
	private Boolean Adult;
}
