package com.example.demo.restApiController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginTable;
import com.example.demo.repository.UserDetailRepository;

/*
 * @Service public class CustomUserDetailsService implements UserDetailsService
 * {
 * 
 * 
 * @Autowired private UserDetailRepository userDetailRepository;
 * 
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException { LoginTable
 * user=this.userDetailRepository.findByUsername(username); if(user==null) {
 * throw new UsernameNotFoundException("No User"); }
 * 
 * 
 * return new AuthResponse(user); }
 * 
 * 
 * }
 */