package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.DataComputingModel;

@SpringBootApplication
@EnableEurekaClient
@EntityScan(basePackages = {"com.example.demo.model"})
public class DataComputingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataComputingApplication.class, args);
	}

   

    @Bean
    DataComputingModel dataComputingModel()
	{
		return new DataComputingModel();
	}
	
	 @Value("${api.url}")
	    String apiUrl;

    @Bean
    String apiURL() {
	        return apiUrl;
	    }
	
}
