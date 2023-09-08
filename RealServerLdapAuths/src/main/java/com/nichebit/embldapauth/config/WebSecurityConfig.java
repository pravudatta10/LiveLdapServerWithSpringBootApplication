package com.nichebit.embldapauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
		return http.build();
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().userSearchFilter("(uid={0})").userSearchBase("dc=nichebit,dc=com")
				.groupSearchFilter("uniqueMember={0}").groupSearchBase("ou=People,dc=nichebit,dc=com")
				.userDnPatterns("uid={0}").contextSource().url("ldap://192.168.2.111:389")
				.managerDn("cn=admin,dc=nichebit,dc=com").managerPassword("nichebit");
	}
}

 