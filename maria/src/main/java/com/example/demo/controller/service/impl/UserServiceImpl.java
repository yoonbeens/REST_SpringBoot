package com.example.demo.controller.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.service.UserService;
//import com.example.demo.data.dao.UserDAO;
import com.example.demo.data.dto.UserDTO;
import com.example.demo.data.handler.UserDataHandler;
import com.example.demo.data.request.UserSearchRequest;


@Service
public class UserServiceImpl implements UserService {
	
	private UserDataHandler userDataHandler;
	private UserSearchRequest request;
	private UserDTO userDTO;
	
	@Autowired
	public UserServiceImpl(UserDataHandler userDataHandler, UserSearchRequest request, UserDTO userDTO) {
		
		this.userDataHandler = userDataHandler;
		this.request = request;
		this.userDTO = userDTO;
	}
	
	@Override
	public UserSearchRequest getUser(Integer userId) {
		
		UserDTO userDTO = userDataHandler.getUserData(userId);
		
		this.request.setId(userDTO.getId());
		this.request.setName(userDTO.getName());
		this.request.setAge(userDTO.getAge());
		
		return request;
	}
	
	@Override
	public UserSearchRequest saveUser(UserSearchRequest request) {
		
		this.userDTO.setId(request.getId());
		this.userDTO.setName(request.getName());
		this.userDTO.setAge(request.getAge());
		
		this.userDTO = userDataHandler.saveUserData(this.userDTO);
		 
		this.request.setId(this.userDTO.getId());
		this.request.setName(this.userDTO.getName());
		this.request.setAge(this.userDTO.getAge());
		
		return this.request;
		
	}
}
