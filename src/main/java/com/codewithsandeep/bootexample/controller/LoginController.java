package com.codewithsandeep.bootexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.codewithsandeep.bootexample.dto.AdminDto;
import com.codewithsandeep.bootexample.dto.DonarDto;
import com.codewithsandeep.bootexample.dto.LoginDto;
import com.codewithsandeep.bootexample.dto.PartnerDto;
import com.codewithsandeep.bootexample.dto.StaffDto;
import com.codewithsandeep.bootexample.payloads.ApiResponse;
import com.codewithsandeep.bootexample.service.AdminService;
import com.codewithsandeep.bootexample.service.DonarService;
import com.codewithsandeep.bootexample.service.LoginService;
import com.codewithsandeep.bootexample.service.PartnerService;
import com.codewithsandeep.bootexample.service.StaffService;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DonarService donarService;
	
	@Autowired
	private PartnerService partnerService;
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/get/{loginUsername}/{loginPassword}")
	public Object getLogin(@PathVariable String loginUsername, @PathVariable String loginPassword)
	{
		LoginDto login = this.loginService.getLogin(loginUsername, loginPassword);
		
		if(login.getLoginType().equalsIgnoreCase("staff"))
		{
			StaffDto staffDto = this.staffService.getStaffByLOgin(login);
			return staffDto;
		}else if(login.getLoginType().equalsIgnoreCase("admin"))
		{
			AdminDto adminDto = this.adminService.getAdminByLogin(login);
			return adminDto;
		}else if(login.getLoginType().equalsIgnoreCase("partner"))
		{
			PartnerDto partnerDto = this.partnerService.getPartenrByLogin(login);
			return partnerDto;
		}else if(login.getLoginType().equalsIgnoreCase("donar"))
		{
			DonarDto donarDto = this.donarService.getDonarByLogin(login);
			return donarDto;
		}
		
		return new ResponseEntity<>(new ApiResponse("login credentials are invalid !!", false), HttpStatus.NOT_FOUND);
		
	}
	
	
	

}
