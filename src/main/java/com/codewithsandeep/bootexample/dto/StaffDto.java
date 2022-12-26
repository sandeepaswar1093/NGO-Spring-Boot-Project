package com.codewithsandeep.bootexample.dto;

import com.codewithsandeep.bootexample.model.Address;

import jakarta.persistence.Embedded;
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
public class StaffDto {

	private Long staffId;

	@NotEmpty
	@Size(min = 3, max = 20, message = "Name must be at least 3 character!!")
	private String staffName;

	@NotEmpty
	@Size(min = 10, max = 10, message = "Contact Number Should be 10 digits")
	private Long staffContact;

	@NotEmpty
	@Size(min = 12, max = 12, message = "Adhar must be 12 digits !!")
	private Long staffAdhar;

	@NotEmpty
	private String staffDesignation;

	@NotEmpty
	private String staffGender;

	@NotEmpty
	private String staffDob;

	@Embedded
	private Address address;

}
