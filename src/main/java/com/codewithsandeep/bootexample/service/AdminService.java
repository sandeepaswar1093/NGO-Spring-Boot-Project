package com.codewithsandeep.bootexample.service;

import java.util.List;

import com.codewithsandeep.bootexample.dto.AdminDto;
import com.codewithsandeep.bootexample.dto.LoginDto;

public interface AdminService {
	
	public AdminDto createAdmin(AdminDto adminDto);
	
	public AdminDto updateAdmin(AdminDto adminDto, Long adminId);
	
	public List<AdminDto> getAllAdmin();
	
	public void deleteAdmin(Long adminId);
	
	public AdminDto getAdminByLogin(LoginDto loginDto);

}
