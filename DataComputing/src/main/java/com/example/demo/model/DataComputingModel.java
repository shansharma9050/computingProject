package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "testVelocis")
@Data
public class DataComputingModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "title")
    private String title;
    
    @Column(name = "name")
    private String name;

     
    @Column(name = "description")
    private String description;

    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "PHONE_NUMBER")
    private Long phNumber;
    
    @Column(name = "DATE_OF_BIRTH")
    private String dob;
    
    @Transient
    private String message;

}
