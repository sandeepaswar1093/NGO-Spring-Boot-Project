package com.codewithsandeep.bootexample.service;

import java.util.List;

import com.codewithsandeep.bootexample.dto.StaffDto;

public interface StaffService {

	public StaffDto createStaff(StaffDto staffDto);

	public StaffDto updateStaff(StaffDto staffDto, Long staffId);

	public List<StaffDto> getAllStaff();

	public void deleteStaff(Long staffId);

}
