package com.erensayar.homecamerasecurity.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${security.username}")
  private String username;

  @Value("${security.password}")
  private String password;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/static/**", "/webjars/**").permitAll()
        .antMatchers("/home").access("hasRole('USER')")
        .anyRequest()
        .authenticated()
        .and().formLogin().loginPage("/login").permitAll()
        .and().logout().permitAll();

    //http.csrf().disable();
  }

  @Bean
  @Override
  public UserDetailsService userDetailsService() {

    UserDetails user
        = User.withDefaultPasswordEncoder()
        .username(username)
        .password(password)
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(user);
  }


}
