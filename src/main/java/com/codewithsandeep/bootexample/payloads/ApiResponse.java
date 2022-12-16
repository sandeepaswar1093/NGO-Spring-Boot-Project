package com.codewithsandeep.bootexample.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {

	private String mesage;
	private boolean status;
}
