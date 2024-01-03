package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
@Component
public class CustomConfiguration {

	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable().authorizeHttpRequests().antMatchers("/home/**").hasRole
	 * ("public").anyRequest()
	 * .authenticated().and().formLogin().permitAll().and().logout()
	 * .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
	 * 
	 * }
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("Ashish").password(passwordEncoder().
	 * encode("pagla")).roles("public"); }
	 */

	/*
	 * @Bean public UserDetailsService userDetaisService() { UserDetails firstUser =
	 * User.withUsername("shankar").password(passwordEncoder().encode("shankar"))
	 * .roles("admin").build();
	 * 
	 * UserDetails secUser =
	 * User.withUsername("baccha").password(passwordEncoder().encode("baccha")).
	 * roles("user") .build();
	 * 
	 * return new InMemoryUserDetailsManager(firstUser, secUser); }
	 */

	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity httpSecurity)
	 * throws Exception { httpSecurity.csrf().disable() .authorizeHttpRequests()
	 * .antMatchers("/home/**") .hasRole("admin") .antMatchers("/home/setdata")
	 * .hasRole("user")
	 * 
	 * .antMatchers("/home/submit-all-details-of-user") .permitAll()
	 * 
	 * .anyRequest() .authenticated() .and() .formLogin() .permitAll() .and()
	 * .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	 * .permitAll(); return httpSecurity.build(); }
	 */
}
