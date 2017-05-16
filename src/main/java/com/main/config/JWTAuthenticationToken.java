package com.main.config;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class JWTAuthenticationToken extends UsernamePasswordAuthenticationToken {

	
   
	public JWTAuthenticationToken(String jwtToken) {
		super("","");
		this.jwtToken = jwtToken;
		setAuthenticated(true);
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 4941121308656700685L;
	
	
    
	private String jwtToken;
 
    
    
	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return jwtToken;
	}
	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}
 
  

}
