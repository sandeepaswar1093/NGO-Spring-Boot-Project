package com.codewithsandeep.bootexample.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsandeep.bootexample.dto.LoginDto;
import com.codewithsandeep.bootexample.dto.PartnerDto;
import com.codewithsandeep.bootexample.exception.ResourceNotFoundException;
import com.codewithsandeep.bootexample.model.Partner;
import com.codewithsandeep.bootexample.repository.PartnerRepository;
import com.codewithsandeep.bootexample.service.PartnerService;

@Service
public class PartnerServiceImpl implements PartnerService {

	@Autowired
	private PartnerRepository partnerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PartnerDto createPartner(PartnerDto partnerDto) {
		Partner partner = this.modelMapper.map(partnerDto, Partner.class);
		Partner savePartner = this.partnerRepository.save(partner);
		return this.modelMapper.map(savePartner, PartnerDto.class);
	}

	@Override
	public PartnerDto updatePartner(PartnerDto partnerDto, Long partnerId) {
		Partner partner = this.partnerRepository.findById(partnerId)
				.orElseThrow(() -> new ResourceNotFoundException("Partner", "Partner Id", partnerId));
		partner.setPartnerName(partnerDto.getPartnerName());
		partner.setPartnerContact(partnerDto.getPartnerContact());
		partner.setPartnerOrganization(partnerDto.getPartnerOrganization());
		partner.setPartnerWebsite(partnerDto.getPartnerWebsite());
		Partner updatePartner = this.partnerRepository.save(partner);
		return this.modelMapper.map(updatePartner, PartnerDto.class);
	}

	@Override
	public List<PartnerDto> getAllPartner() {
		List<Partner> partnerList = this.partnerRepository.findAll();
		List<PartnerDto> partnerDtos = partnerList.stream()
				.map((partner) -> this.modelMapper.map(partner, PartnerDto.class)).collect(Collectors.toList());
		return partnerDtos;
	}

	@Override
	public void deletePartner(Long partnerId) {
		Partner partner = this.partnerRepository.findById(partnerId)
				.orElseThrow(() -> new ResourceNotFoundException("Partner", "Partner Id", partnerId));
		this.partnerRepository.delete(partner);

	}

	@Override
	public PartnerDto getPartenrByLogin(LoginDto loginDto) {
		Partner partner = this.partnerRepository.findByLogin(loginDto);
		return this.modelMapper.map(partner, PartnerDto.class);
	}

}
