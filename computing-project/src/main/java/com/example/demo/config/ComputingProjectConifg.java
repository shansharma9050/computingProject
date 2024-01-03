package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.stereotype.Component;

@Component

@Configuration
public class ComputingProjectConifg {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
}

//Form login security WebSecurityConfigurerAdapter

/*
 * @EnableWebSecurity public class ComputingProjectConifg extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Autowired private CustomUserDetailsService customUserDetailsService;
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()
 * ).and() .authorizeRequests() .antMatchers("/myHome/**").permitAll()
 * .antMatchers("/home/signin").permitAll()
 * .antMatchers("/home/**").hasRole("admin").anyRequest() .authenticated().and()
 * .formLogin() .loginPage("/home/signin") .loginProcessingUrl("/dologin")
 * .defaultSuccessUrl("/home/computingProject");
 * 
 * }
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * 
 * auth.userDetailsService(customUserDetailsService).passwordEncoder(
 * passwordEncoder());
 * 
 * 
 * auth.inMemoryAuthentication().withUser("pritesh").password(this.
 * passwordEncoder().encode("sita")) .roles("admin");
 * auth.inMemoryAuthentication().withUser("shankar").password(this.
 * passwordEncoder().encode("ram")) .roles("normal");
 * 
 * }
 * 
 * // need not passwordEncoder
 * 
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return
 * NoOpPasswordEncoder.getInstance(); }
 * 
 * 
 * @Bean public PasswordEncoder passwordEncoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * }
 */
