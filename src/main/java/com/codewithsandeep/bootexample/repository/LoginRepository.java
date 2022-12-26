package com.codewithsandeep.bootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsandeep.bootexample.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{
	
	public Login findByLoginUsernameAndLoginPassword(String loginUsername, String loginPassword);

}
