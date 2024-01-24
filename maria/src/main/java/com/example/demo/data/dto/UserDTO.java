package com.example.demo.data.dto;

import org.springframework.stereotype.Component;

import com.example.demo.data.request.UserSearchRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class UserDTO {
	
	private Integer id;
    private String name;
    private Integer age;

}
