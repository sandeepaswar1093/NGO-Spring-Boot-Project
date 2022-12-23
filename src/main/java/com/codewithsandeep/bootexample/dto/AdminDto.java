package com.codewithsandeep.bootexample.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
	
	@NotEmpty
	@Size(min = 3, max = 20, message = "Name must be at least 3 character!!")
	private String adminName;
	
	@NotEmpty
	@Size(min = 10,max = 10,message = "Contact Number Should be 10 digits")
	private String adminContact;
	
	@NotEmpty
	@Size(min = 12,max =12, message = "Adhar must be 12 digits !!")
	private String adminAdhar;
	
	@NotEmpty
	private String adminGender;
}
