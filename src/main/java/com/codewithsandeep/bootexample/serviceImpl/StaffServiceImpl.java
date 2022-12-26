package com.codewithsandeep.bootexample.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsandeep.bootexample.dto.LoginDto;
import com.codewithsandeep.bootexample.dto.StaffDto;
import com.codewithsandeep.bootexample.exception.ResourceNotFoundException;
import com.codewithsandeep.bootexample.model.Staff;
import com.codewithsandeep.bootexample.repository.StaffRepository;
import com.codewithsandeep.bootexample.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StaffDto createStaff(StaffDto staffDto) {
		Staff staff = this.modelMapper.map(staffDto, Staff.class);
		Staff save = this.staffRepository.save(staff);
		StaffDto dtoObj = this.modelMapper.map(save, StaffDto.class);
		return dtoObj;
	}

	@Override
	public StaffDto updateStaff(StaffDto staffDto, Long staffId) {
		Staff staff = this.staffRepository.findById(staffId)
				.orElseThrow(() -> new ResourceNotFoundException("Staff", "StaffId", staffId));
		staff.setStaffName(staffDto.getStaffName());
		staff.setStaffAdhar(staffDto.getStaffAdhar());
		staff.setStaffContact(staffDto.getStaffContact());
		staff.setStaffDesignation(staffDto.getStaffDesignation());
		staff.setStaffGender(staffDto.getStaffGender());
		staff.setStaffDob(staffDto.getStaffDob());
		Staff updateStaff = this.staffRepository.save(staff);
		StaffDto dtos = this.modelMapper.map(updateStaff, StaffDto.class);
		return dtos;
	}

	@Override
	public List<StaffDto> getAllStaff() {
		List<Staff> list = this.staffRepository.findAll();
		List<StaffDto> staffDtos = list.stream().map((staff) -> this.modelMapper.map(staff, StaffDto.class))
				.collect(Collectors.toList());

		return staffDtos;
	}

	@Override
	public void deleteStaff(Long staffId) {
		Staff staff = this.staffRepository.findById(staffId)
				.orElseThrow(() -> new ResourceNotFoundException("Staff", "Staff Id", staffId));
		this.staffRepository.delete(staff);

	}

	@Override
	public StaffDto getStaffByLOgin(LoginDto loginDto) {
		Staff staff = this.staffRepository.findByLogin(loginDto);
		return this.modelMapper.map(staff, StaffDto.class);
	}

}
