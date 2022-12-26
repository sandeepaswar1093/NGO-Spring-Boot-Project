package com.codewithsandeep.bootexample.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partner_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "partner_id")
	private Long partnerId;

	@Column(name = "partner_name")
	private String partnerName;

	@Column(name = "partner_contact")
	private Long partnerContact;

	@Column(name = "partner_organization")
	private String partnerOrganization;

	@Column(name = "partner_website")
	private String partnerWebsite;
	
	@Embedded
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "login_id")
	private Login login;

	
}
