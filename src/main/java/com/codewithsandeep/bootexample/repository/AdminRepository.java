package com.codewithsandeep.bootexample.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithsandeep.bootexample.dto.AdminDto;
import com.codewithsandeep.bootexample.dto.LoginDto;
import com.codewithsandeep.bootexample.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Serializable>{
	
	public Admin findByLogin(LoginDto login);

}