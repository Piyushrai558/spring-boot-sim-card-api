package com.piyushrai.blog.servicesImpl;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piyushrai.blog.entities.SimCardApi;
import com.piyushrai.blog.exceptions.ResourceNotFoundException;
import com.piyushrai.blog.payloads.SimCardApiDto;
import com.piyushrai.blog.repositories.SimCardApiRepo;
import com.piyushrai.blog.services.SimCardApiServices;

@Service
public class SimCardApiServicesImpl implements SimCardApiServices {
	
	@Autowired
	private SimCardApiRepo simCardApiRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public SimCardApiDto createUser(SimCardApiDto simCardApiDto) {
		// TODO Auto-generated method stub
		SimCardApi user = this.modelMapper.map(simCardApiDto, SimCardApi.class);
		SimCardApi addedUser = this.simCardApiRepo.save(user);
		return this.modelMapper.map(addedUser, SimCardApiDto.class);
	}

	@Override
	public SimCardApiDto updateUser(SimCardApiDto user, Integer Id) {
		// TODO Auto-generated method stub

		SimCardApi cat = this.simCardApiRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("SimCardApi", "SimCardApi Id", Id));
		cat.setSim_card_no(user.getSim_card_no());;
		cat.setExpiryDate(user.getExpiryDate());;;
		cat.setFullName(user.getFullName());;
		cat.setKyc(user.getKyc());;
		cat.setMobile_no(user.getMobileNo());;
		cat.setStateOfRegistration(user.getStateOfRegistration());;
		cat.setStatus(user.getStatus());;
		cat.setTelecomProvider(user.getTelecomProvider());;

		
		SimCardApi updatedCat = this.simCardApiRepo.save(cat);
		return this.modelMapper.map(updatedCat, SimCardApiDto.class);
	}

	@Override
	public SimCardApiDto getUserById(Integer Id) {
		// TODO Auto-generated method stub

		SimCardApi cat = this.simCardApiRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("SimCardApi", "SimCardApi Id", Id));
		
		return this.modelMapper.map(cat, SimCardApiDto.class);
		
	}

	@Override
	public List<SimCardApiDto> getAllUsers() {
		// TODO Auto-generated method stub

		List<SimCardApi> categories = this.simCardApiRepo.findAll();
		List<SimCardApiDto> categoriesDto= categories.stream().map((cat) -> this.modelMapper.map(cat, SimCardApiDto.class)).collect(Collectors.toList());
		
		return categoriesDto;
		
	}

	@Override
	public void deleteUser(Integer Id) {
		// TODO Auto-generated method stub
		SimCardApi cat = this.simCardApiRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("SimCardApi", "Id", Id));
		this.simCardApiRepo.delete(cat);
		
	}

	/*
	 * @Override public List<SimCardApiDto> getAllBetweenDate(Date startDate, Date
	 * endDate) { // TODO Auto-generated method stub return null; }
	 */

	/*
	 * @Override public SimCardApiDto renewUser(SimCardApiDto user, Integer
	 * Id, Date endDate) { // TODO Auto-generated method stub return null;
	 * }
	 */
	

}
