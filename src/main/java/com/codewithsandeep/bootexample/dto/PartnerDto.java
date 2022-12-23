package com.codewithsandeep.bootexample.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDto {

	private Long partnerId;
	
	@NotEmpty
	@Size(min = 3, max = 20, message = "Name must be at least 3 character!!")
	private String partnerName;
	
	@NotEmpty
	@Size(min = 10, max = 10, message = "Contact Number Should be 10 digits")
	private Long partnerContact;
	
	@NotEmpty
	@Size(min = 3, max =20, message = "Please Enter Valid Organization Name")
	private String partnerOrganization;
	
	@NotEmpty
	@Pattern(regexp = "^((https?|ftp|smtp):\\/\\/)?(www.)?[a-z0-9]+\\.[a-z]+(\\/[a-zA-Z0-9#]+\\/?)*$")
	private String partnerWebsite;

}
