package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	//DB에서 가져오는 건 JPA가 Bean으로 알아서
}
