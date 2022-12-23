package com.codewithsandeep.bootexample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "donar_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Donar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "donar_id")
	private Long donarId;
	
	@Column(name = "donar_name")
	private String donarName;
	
	@Column(name ="doanr_contact")
	private Long donarContact;
	
	@Column(name = "donar_adhar")
	private Long donarAdhar;
	
	@Column(name = "donar_dob")
	private String donarDob;
	
	@Column(name = "donar_pan")
	private String donarPAN;
	
	@Column(name = "donar_amount")
	private Double donarAmount;

}
