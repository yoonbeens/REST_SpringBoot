package com.example.demo.data.handler.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.dao.UserDAO;
import com.example.demo.data.dto.UserDTO;
import com.example.demo.data.entity.VipUser;
import com.example.demo.data.handler.UserDataHandler;

@Service
public class UserDataHandlerImpl implements UserDataHandler {
	
	private final UserDAO userDAO;
//	private UserDTO userDTO;
	
	@Autowired
	public UserDataHandlerImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
//		this.userDTO = userDTO;
	}
	
	@Override
	public UserDTO getUserData(Integer userId) {
		
//		this.userDTO = userDAO.getUser(userId);
//		
//		return this.userDTO;
		
		return userDAO.getUser(userId);
	}
	
	@Override
	public UserDTO saveUserData(UserDTO userDTO) {
		
		return userDAO.saveUser(userDTO);
	}

}
