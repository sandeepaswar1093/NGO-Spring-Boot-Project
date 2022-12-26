package com.codewithsandeep.bootexample.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsandeep.bootexample.dto.LoginDto;
import com.codewithsandeep.bootexample.model.Login;
import com.codewithsandeep.bootexample.repository.LoginRepository;
import com.codewithsandeep.bootexample.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public LoginDto getLogin(String loginUsername, String loginPassword) {
		Login loginUsernameAndLoginPassword = this.loginRepository.findByLoginUsernameAndLoginPassword(loginUsername,
				loginPassword);
		return this.modelMapper.map(loginUsernameAndLoginPassword, LoginDto.class);
	}

}
