package com.codewithsandeep.bootexample.dto;

import com.codewithsandeep.bootexample.model.Address;

import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonarDto {

	private Long donarId;

	@NotEmpty
	@Size(min = 3, max = 20, message = "Name must be at least 3 character!!")
	private String donarName;

	@NotEmpty
	@Size(min = 10, max = 10, message = "Contact Number Should be 10 digits")
	private Long donarContact;

	@NotEmpty
	@Size(min = 12, max = 12, message = "Adhar must be 12 digits !!")
	private Long donarAdhar;

	@NotNull(message = "The date of birth is required.")
	@Past(message = "The date of birth must be in the past.")
	private String donarDob;

	@NotEmpty
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}")
	private String donarPAN;
	
    @NotEmpty
	private Double donarAmount;
    
    @Embedded
	private Address address;

    

}
