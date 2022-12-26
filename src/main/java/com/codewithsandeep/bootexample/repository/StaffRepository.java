package com.codewithsandeep.bootexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithsandeep.bootexample.dto.LoginDto;
import com.codewithsandeep.bootexample.model.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long>{
	
	public Staff findByLogin(LoginDto login);

}
