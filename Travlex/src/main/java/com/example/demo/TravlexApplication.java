package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ComputingProjectModel;

@SpringBootApplication
@EnableDiscoveryClient
public class TravlexApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravlexApplication.class, args);
	}

	
	@Bean
	RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean
	ComputingProjectModel computingProjectModel()
	{
		return new ComputingProjectModel();
	}
	
	
	@Value("${api.url}") 
	 String apiURL;
	
	@Bean
	public String apiURL() 
	{ 
		return apiURL;
	
	}
}
