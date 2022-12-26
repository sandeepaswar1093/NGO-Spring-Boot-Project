package com.codewithsandeep.bootexample.service;

import com.codewithsandeep.bootexample.dto.LoginDto;

public interface LoginService {
	
  public LoginDto getLogin(String loginUsername, String loginPassword);
}
