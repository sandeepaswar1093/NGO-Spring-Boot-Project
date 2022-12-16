package com.codewithsandeep.bootexample.service;

import java.util.List;

import com.codewithsandeep.bootexample.dto.AdminDto;

public interface AdminService {
	
	public AdminDto createAdmin(AdminDto adminDto);
	
	public AdminDto updateAdmin(AdminDto adminDto, Long adminId);
	
	public List<AdminDto> getAllAdmin();
	
	public void deleteAdmin(Long adminId);

}
