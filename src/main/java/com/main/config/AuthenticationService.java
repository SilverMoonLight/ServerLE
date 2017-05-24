package com.main.config;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService extends AbstractUserDetailsAuthenticationProvider {

	private Logger logger = Logger.getLogger(AuthenticationService.class);
	
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JWTAuthenticationToken jwtAuthenticationToken = (JWTAuthenticationToken) authentication;
		String password = (String) jwtAuthenticationToken.getCredentials();
		String user = (String) jwtAuthenticationToken.getPrincipal();
		Collection<? extends GrantedAuthority> authorities = jwtAuthenticationToken.getAuthorities();
		
		return new User(user, password, authorities);
	}

}
