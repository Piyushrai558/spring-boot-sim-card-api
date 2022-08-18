package com.piyushrai.blog.controllers;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piyushrai.blog.payloads.ApiResponse;
import com.piyushrai.blog.payloads.SimCardApiDto;
import com.piyushrai.blog.services.SimCardApiServices;

@RestController
@RequestMapping("/api/simcardapi")
public class SimCardApiControllers {
	
	@Autowired
	private SimCardApiServices simCardApiServices;
	
	@GetMapping("/")
	public ResponseEntity<ApiResponse> status200() {
		return new ResponseEntity<ApiResponse>(new ApiResponse(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<SimCardApiDto> createCategory(@Valid @RequestBody SimCardApiDto catdto) {
		SimCardApiDto createCategory = this.simCardApiServices.createUser(catdto);
		return new ResponseEntity<SimCardApiDto>(createCategory, HttpStatus.CREATED);
	}
	
	@PutMapping("/renew/{id}")
	public ResponseEntity<SimCardApiDto> updateCategory(@Valid @RequestBody SimCardApiDto catdto, @PathVariable Integer id){
		SimCardApiDto updatedCategory = this.simCardApiServices.updateUser(catdto, id);
		return new ResponseEntity<SimCardApiDto>(updatedCategory, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> delteCategory(@PathVariable Integer id){
		this.simCardApiServices.deleteUser(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Sucessfully",true ), HttpStatus.OK);
	}
	
	@GetMapping("/listall")
	public ResponseEntity<List<SimCardApiDto>> getAllCategory(){
		List<SimCardApiDto> categorylist = this.simCardApiServices.getAllUsers();
		return new ResponseEntity<List<SimCardApiDto>>(categorylist, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SimCardApiDto> getCategory(@PathVariable Integer id){
		SimCardApiDto category = this.simCardApiServices.getUserById(id);
		return new ResponseEntity<SimCardApiDto>(category, HttpStatus.OK);
	}
	
	@GetMapping("/to-renew")
	public ResponseEntity<List<SimCardApiDto>> getAllCategoryToBeRenewed(){
		Date today = new Date();
		Calendar cal = new GregorianCalendar();
		cal.add(Calendar.DAY_OF_MONTH, -30);
		Date today30 = cal.getTime();
		List<SimCardApiDto> categorylist = this.simCardApiServices.getAllUsers();
		List<SimCardApiDto> listOfToBeRenewed = categorylist.stream().filter(x -> x.getExpiryDate().before(today30)).collect(Collectors.toList());
		return new ResponseEntity<List<SimCardApiDto>>(listOfToBeRenewed, HttpStatus.OK);
	}

}
