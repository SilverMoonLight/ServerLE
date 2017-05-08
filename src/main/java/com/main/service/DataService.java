package com.main.service;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.main.dataentity.Client;
import com.main.repo.ClientRepo;

@Service("dataService")
@Transactional
public class DataService extends AbstractUserDetailsAuthenticationProvider  {
	
	private Logger logger = Logger.getLogger(DataService.class);
	
	@Autowired
	ClientRepo clientRepo;
	
	@Autowired
	@Qualifier("brcypt")
	BCryptPasswordEncoder encoder;

	

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		String password = authentication.getCredentials().toString();
		UserDetails loadedUser = null;
		logger.info("Data Service password, email: " + username + " " + password );
		Client client = clientRepo.findClientByEmailAndPassword(username, password);
		GrantedAuthority authority = new SimpleGrantedAuthority(client.getRole().getRoleName());
		loadedUser = new User(username, password, Arrays.asList(authority));
		return loadedUser;
	}

	

}
