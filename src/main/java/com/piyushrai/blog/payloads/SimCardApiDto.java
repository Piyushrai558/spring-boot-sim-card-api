package com.piyushrai.blog.payloads;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class SimCardApiDto {
	
	
	private Integer Id;
	
	@NotNull
	private Integer sim_card_no; 
	
	
	@NotNull
	private long mobileNo;
	
	@NotBlank
	private String status;
	
	
	private Date expiryDate;
	
	@Size(min=2, message="UserName must be min of 4 character")
	private String stateOfRegistration;
	
	private Boolean kyc; 
	
	@Size(min=2, message="UserName must be min of 4 character")
	private String telecomProvider;
	

	@Size(min=4, message="UserName must be min of 4 character")
	private String fullName;

}
