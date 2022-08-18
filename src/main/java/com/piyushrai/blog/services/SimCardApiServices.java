package com.piyushrai.blog.services;

import java.util.Date;
import java.util.List;

import com.piyushrai.blog.payloads.SimCardApiDto;

public interface SimCardApiServices {
	
	SimCardApiDto createUser(SimCardApiDto user);
	SimCardApiDto updateUser(SimCardApiDto user, Integer sim_card_no);
	SimCardApiDto getUserById(Integer sim_card_no);
	
	List<SimCardApiDto> getAllUsers();
	void deleteUser(Integer userId);
	/*
	 * List<SimCardApiDto> getAllBetweenDate(Date startDate, Date endDate);
	 * SimCardApiDto renewUser(SimCardApiDto user, Integer sim_card_no, Date
	 * endDate);
	 */
}

