package com.codewithsandeep.bootexample.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsandeep.bootexample.dto.AdminDto;
import com.codewithsandeep.bootexample.exception.ResourceNotFoundException;
import com.codewithsandeep.bootexample.model.Admin;
import com.codewithsandeep.bootexample.repository.AdminRepository;
import com.codewithsandeep.bootexample.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private ModelMapper modelmapper;

	@Override
	public AdminDto createAdmin(AdminDto adminDto) {
		Admin map = this.modelmapper.map(adminDto, Admin.class);
		Admin save = this.adminRepository.save(map);
		return this.modelmapper.map(save, AdminDto.class);
	}

	@Override
	public AdminDto updateAdmin(AdminDto adminDto, Long adminId) {

		Admin admin = this.adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin", "AdminId", adminId));
		admin.setAdminName(adminDto.getAdminName());
		admin.setAdminContact(adminDto.getAdminContact());
		admin.setAdminAdhar(adminDto.getAdminAdhar());
		admin.setAdminGender(adminDto.getAdminGender());
		Admin saveAdmin = this.adminRepository.save(admin);

		return this.modelmapper.map(saveAdmin, AdminDto.class);
	}

	@Override
	public List<AdminDto> getAllAdmin() {
		List<Admin> list = this.adminRepository.findAll();
		List<AdminDto> adminDtos = list.stream().map((admin) -> this.modelmapper.map(admin, AdminDto.class))
				.collect(Collectors.toList());
		return adminDtos;
	}

	@Override
	public void deleteAdmin(Long adminId) {
		Admin admin = this.adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
		this.adminRepository.delete(admin);
	}

}
