package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="COMPUTPROData")
@Data
public class compProj {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL") 
	private String email;
	
	@Column(name="PH_NUMBER")
	private Long phNumber;
	
	@Column(name="DOB")
	private Date dob;
	
}