package com.codewithsandeep.bootexample.service;

import java.util.List;

import com.codewithsandeep.bootexample.dto.PartnerDto;

public interface PartnerService {
	
	public PartnerDto createPartner(PartnerDto partnerDto);
	
	public PartnerDto updatePartner(PartnerDto partnerDto, Long partnerId);
	
	public List<PartnerDto> getAllPartner();
	
	public void deletePartner(Long partnerId);

}
