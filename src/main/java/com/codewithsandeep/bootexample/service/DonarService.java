package com.codewithsandeep.bootexample.service;

import java.util.List;

import com.codewithsandeep.bootexample.dto.DonarDto;
import com.codewithsandeep.bootexample.dto.LoginDto;

public interface DonarService {

	public DonarDto createDonar(DonarDto donarDto);

	public DonarDto updateDonar(DonarDto donarDto, Long donarId);

	public List<DonarDto> getAllDonar();

	public void deleteDonar(Long doanrId);
	
	public DonarDto getDonarByLogin(LoginDto loginDto);

}
