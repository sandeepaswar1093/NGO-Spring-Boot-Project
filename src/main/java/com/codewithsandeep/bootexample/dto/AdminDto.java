package com.codewithsandeep.bootexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

	private Long adminId;
	
	private String adminName;
	
	private String adminContact;
	
	private String adminAdhar;
	
	private String adminGender;
}
