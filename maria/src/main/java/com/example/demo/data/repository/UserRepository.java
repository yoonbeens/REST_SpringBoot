package com.example.demo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entity.VipUser;

@Repository
public interface UserRepository extends JpaRepository<VipUser, Integer> {
	
}
