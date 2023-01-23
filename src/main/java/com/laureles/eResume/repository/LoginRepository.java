package com.laureles.eResume.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laureles.eResume.entity.Login;


public interface LoginRepository extends JpaRepository<Login, Long>{

	Login findByUserName(String userName);
	
}
