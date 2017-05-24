package com.main.service;

import com.main.config.JWTAuthenticationToken;
import com.main.dataentity.Client;

public interface DataServiceInterface {
	
		
		
		void saveClient(Client client);
		
		String retrieveUser(String username, String password);
}
