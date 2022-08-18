package com.piyushrai.blog.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sim_card_api")
@NoArgsConstructor
@Setter
@Getter
public class SimCardApi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name="sim_card_no", nullable=false, length=20, unique=true)
	private Integer sim_card_no; 
	
	@Column(name="mobile_no", nullable=false, length=10)
	private long mobile_no;
	
	@Column(name="status", nullable=false, length=10)
	private String status;
	
	@Column(name="expiry_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date expiryDate;
	
	@Column(name="state_of_Registration", length=100)
	private String stateOfRegistration;
	
	@Column(name="kyc", nullable=false, length=10)
	private Boolean kyc; 
	
	@Column(name="telecom_provider", length=100)
	private String telecomProvider;
	
	@Column(name="fullName", nullable=false, length=100)
	private String fullName;
}
