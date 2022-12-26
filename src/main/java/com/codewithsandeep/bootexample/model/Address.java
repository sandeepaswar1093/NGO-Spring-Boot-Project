package com.codewithsandeep.bootexample.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {

	private String area;

	private String street;

	private String city;
	
	private String state;

	private Long pincode;

}
