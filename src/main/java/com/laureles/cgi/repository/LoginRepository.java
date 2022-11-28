package com.laureles.cgi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laureles.cgi.entity.Login;


public interface LoginRepository extends JpaRepository<Login, Long>{

	Login findByUserName(String userName);
	
}
