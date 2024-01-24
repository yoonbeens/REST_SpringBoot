package com.example.demo.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.dao.UserDAO;
import com.example.demo.data.dto.UserDTO;
import com.example.demo.data.entity.VipUser;
import com.example.demo.data.repository.UserRepository;

@Service
public class UserDAOImpl implements UserDAO {
	
	private final UserRepository userRepository;
	private final UserDTO userDTO;
	private VipUser user;
	
	@Autowired
	public UserDAOImpl(UserRepository userRepository, UserDTO userDTO, VipUser user) {
		this.userRepository = userRepository;
		this.userDTO = userDTO;
		this.user = user;
		
	}
	
	@Override
	public UserDTO getUser(Integer userId) {
		
		VipUser user = this.userRepository.getReferenceById(userId);
		
		this.userDTO.setId(user.getUserId());
		this.userDTO.setName(user.getUserName());
		this.userDTO.setAge(user.getUserAge());
		
		return userDTO;
	}
	
	@Override
	public UserDTO saveUser(UserDTO userDTO) {
		
		this.user.setUserId(userDTO.getId());
		this.user.setUserName(userDTO.getName());
		this.user.setUserAge(userDTO.getAge());
		
		this.user.setAdult(userDTO.getAge() > 19 ? true : false);
		 
		this.user = this.userRepository.save(user);
		
		userDTO.setId(this.user.getUserId());
		userDTO.setName(this.user.getUserName());
		userDTO.setAge(this.user.getUserAge());
		
		return userDTO;
	}

}
