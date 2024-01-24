package com.example.demo.controller.service;

import com.example.demo.data.request.UserSearchRequest;

public interface UserService {
	
	UserSearchRequest getUser(Integer userId);
	UserSearchRequest saveUser(UserSearchRequest request);

}
