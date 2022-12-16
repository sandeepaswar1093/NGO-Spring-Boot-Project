package com.codewithsandeep.bootexample.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {

	private String staffName;

	private Long staffContact;

	private Long staffAdhar;

	private String staffDesignation;

	private String staffGender;

	private String staffDob;

}
