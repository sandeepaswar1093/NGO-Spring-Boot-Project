package com.codewithsandeep.bootexample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "STAFF_DETAILS")
@Getter
@Setter
@AllArgsConstructor
public class Staff {
	
	@Id
	@Column(name = "staff_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long staffId;
	
	@Column(name ="staff_name")
	private String staffName;
	
	@Column(name = "staff_contact")
	private Long staffContact;
	
	@Column(name ="staff_adhar")
	private Long staffAdhar;
	
	@Column(name ="staff_designation")
	private String staffDesignation;
	
	@Column(name = "staff_gender")
	private String staffGender;
	
	@Column(name ="staff_dob")
	private String staffDob;

}
