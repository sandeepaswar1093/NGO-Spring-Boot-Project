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

import com.codewithsandeep.bootexample.dto.DonarDto;
import com.codewithsandeep.bootexample.payloads.ApiResponse;
import com.codewithsandeep.bootexample.service.DonarService;

@RestController
@RequestMapping("api")
public class DonarController {

	@Autowired
	private DonarService donarService;
	
	
	@PostMapping("/")
	public ResponseEntity<DonarDto> createDonar(@RequestBody DonarDto donarDto)
	{
		DonarDto createDonar = this.donarService.createDonar(donarDto);
		return new ResponseEntity<DonarDto>(createDonar, HttpStatus.CREATED);	
	}
	
	@PutMapping("/{donarId}")
	public ResponseEntity<DonarDto> updateDonar(@RequestBody DonarDto donarDto, @PathVariable Long donarId)
	{
		DonarDto updateDonar = this.donarService.updateDonar(donarDto, donarId);
		return new ResponseEntity<DonarDto>(updateDonar,HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<DonarDto>> getAllDonar()
	{
		List<DonarDto> allDonar = this.donarService.getAllDonar();
		return new ResponseEntity<List<DonarDto>>(allDonar, HttpStatus.OK);
	}
	
	@DeleteMapping("/{donarId}")
	public ResponseEntity<ApiResponse> deleteDonar(@PathVariable Long donarId)
	{
		this.donarService.deleteDonar(donarId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("The Donar deleted Sucessfully !!  " + donarId, false),HttpStatus.OK);
	}
	
}
