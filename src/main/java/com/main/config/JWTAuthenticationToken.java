package com.main.config;


import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;


public class JWTAuthenticationToken extends UsernamePasswordAuthenticationToken {

	
	
	
	
	public JWTAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
		
		
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 4941121308656700685L;
 
    
    
	


	@Override
	public Object getCredentials() {
		return super.getCredentials();
	}


	@Override
	public Object getPrincipal() {
		return super.getPrincipal();
	}


	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return super.getAuthorities();
	}
	
	
 
  

}
