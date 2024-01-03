package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.ComputingProjectModel;
import com.example.demo.model.LoginTable;
import com.example.demo.repository.UserDetailRepository;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.example.demo.model")
public class ComputingProjectApplication /* implements CommandLineRunner */ {


	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Value("${api.url:}")
	String apiURL;

	public static void main(String[] args) {
		SpringApplication.run(ComputingProjectApplication.class, args);

	}

	@Bean
	public String apiURL() {
		return apiURL;

	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	ComputingProjectModel computingProjectModel() {
		return new ComputingProjectModel();
	}

	/*
	 * @Override public void run(String... args) throws Exception { LoginTable user
	 * = new LoginTable(); user.setUsername("pritesh");
	 * user.setPassword(this.passwordEncoder.encode("sita"));
	 * user.setEmail("pritesh@gmail.com"); user.setRole("ROLE_admin");
	 * this.userDetailRepository.save(user);
	 * 
	 * LoginTable user1 = new LoginTable(); user1.setUsername("shankar");
	 * user1.setPassword(this.passwordEncoder.encode("ram"));
	 * user1.setEmail("shankar@gmail.com"); user1.setRole("ROLE_normal");
	 * this.userDetailRepository.save(user1);
	 * 
	 * }
	 */
}
