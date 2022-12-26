package com.codewithsandeep.bootexample.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithsandeep.bootexample.dto.DonarDto;
import com.codewithsandeep.bootexample.dto.LoginDto;
import com.codewithsandeep.bootexample.exception.ResourceNotFoundException;
import com.codewithsandeep.bootexample.model.Donar;
import com.codewithsandeep.bootexample.repository.DonarRepository;
import com.codewithsandeep.bootexample.service.DonarService;

@Service
public class DonarServiceImpl implements DonarService {

	@Autowired
	private DonarRepository donarRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public DonarDto createDonar(DonarDto donarDto) {
		Donar donar = this.modelMapper.map(donarDto, Donar.class);
		Donar savedDonar = this.donarRepository.save(donar);
		DonarDto donarDtoSave = this.modelMapper.map(savedDonar, DonarDto.class);
		return donarDtoSave;
	}

	@Override
	public DonarDto updateDonar(DonarDto donarDto, Long donarId) {
		Donar donar = this.donarRepository.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("Donar", "Donar Id", donarId));
		donar.setDonarName(donarDto.getDonarName());
		donar.setDonarAdhar(donarDto.getDonarAdhar());
		donar.setDonarAmount(donarDto.getDonarAmount());
		donar.setDonarContact(donarDto.getDonarContact());
		donar.setDonarDob(donarDto.getDonarDob());
		donar.setDonarPAN(donarDto.getDonarPAN());
		Donar updateDonar = this.donarRepository.save(donar);
		DonarDto updateDonarDto = this.modelMapper.map(updateDonar, DonarDto.class);
		return updateDonarDto;
	}

	@Override
	public List<DonarDto> getAllDonar() {
		List<Donar> list = this.donarRepository.findAll();
		List<DonarDto> donarDtos = list.stream().map((donar) -> this.modelMapper.map(donar, DonarDto.class))
				.collect(Collectors.toList());
		return donarDtos;
	}

	@Override
	public void deleteDonar(Long donarId) {
		Donar donar = this.donarRepository.findById(donarId)
				.orElseThrow(() -> new ResourceNotFoundException("Donar", "Donar Id", donarId));
		this.donarRepository.delete(donar);

	}

	@Override
	public DonarDto getDonarByLogin(LoginDto loginDto) {
		Donar donar = this.donarRepository.findByLogin(loginDto);
		return this.modelMapper.map(donar, DonarDto.class);
	}

}
