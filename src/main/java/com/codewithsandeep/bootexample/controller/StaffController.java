package com.codewithsandeep.bootexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithsandeep.bootexample.constants.AppConstants;
import com.codewithsandeep.bootexample.dto.StaffDto;
import com.codewithsandeep.bootexample.payloads.ApiResponse;
import com.codewithsandeep.bootexample.service.StaffService;

@RestController
@RequestMapping("/api")
public class StaffController {

	@Autowired
	private StaffService staffService;

	@PostMapping("/save")
	public ResponseEntity<StaffDto> saveStaff(@RequestBody StaffDto staffDto)
	{
		StaffDto createStaff = this.staffService.createStaff(staffDto);
		return new ResponseEntity<StaffDto>(createStaff, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{staffId}")
	public ResponseEntity<StaffDto> updateStaff(@RequestBody StaffDto staffDto, @PathVariable Long staffId)
	{
           StaffDto updateStaff = this.staffService.updateStaff(staffDto, staffId);
           return new ResponseEntity<StaffDto>(updateStaff,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<StaffDto>> getStaff()
	{
		List<StaffDto> allStaff = this.staffService.getAllStaff();
		return new ResponseEntity<List<StaffDto>>(allStaff,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{staffId}")
	public ResponseEntity<ApiResponse> deleteStaff(@PathVariable Long staffId)
	{
		this.staffService.deleteStaff(staffId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(AppConstants.DELETE_STAFF + staffId, false), HttpStatus.OK);
	}
}
