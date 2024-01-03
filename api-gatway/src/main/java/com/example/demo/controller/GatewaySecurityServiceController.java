package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.example.demo.model.AuthResponse;

@Controller
@RequestMapping(value="/home")
public class GatewaySecurityServiceController {



	@Autowired
	private RestTemplate restTemplate;

    private Logger logger=LoggerFactory.getLogger(GatewaySecurityServiceController.class);
		
	@RequestMapping(value="/login")
	public ResponseEntity<AuthResponse> login(@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,@AuthenticationPrincipal OidcUser user,Model model) {
		
		logger.info("user email id: {}",user.getEmail());
		
		//CREATING AUTH RESPONSE OBJECT
		AuthResponse authResponse=new AuthResponse();
		
		authResponse.setUserId(user.getEmail());
		
		authResponse.setAccessTocken(client.getAccessToken().getTokenValue()); 
		
		authResponse.setRefreshTocken(client.getRefreshToken().getTokenValue());
		
		authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
		
		List<String> authority=user.getAuthorities().stream().map(grantedAuthority ->{return grantedAuthority.getAuthority();}).collect(Collectors.toList());
	
		authResponse.setAuthorities(authority);
		
		return new ResponseEntity<>(authResponse, org.springframework.http.HttpStatus.OK);
	}
	

}
