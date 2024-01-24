package com.example.demo.data.dao;

import com.example.demo.data.dto.UserDTO;


public interface UserDAO {

	UserDTO getUser(Integer userId);
	UserDTO saveUser(UserDTO userDTO);
}
