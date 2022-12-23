package com.codewithsandeep.bootexample.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

	private Long loginId;

	private String loginUsername;

	private String loginPassword;

	private String loginType;

}
