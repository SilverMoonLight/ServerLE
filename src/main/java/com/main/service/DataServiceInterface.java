package com.main.service;

import com.main.config.JWTAuthenticationToken;
import com.main.dataentity.Client;

public interface DataServiceInterface {
	
		
		
		void saveClient(Client client);
		
		JWTAuthenticationToken retrieveUser(String username, String password);
}
