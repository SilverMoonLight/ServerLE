package com.main.service;

import java.util.List;

import com.main.config.JWTAuthenticationToken;
import com.main.dataentity.Client;
import com.main.dataentity.Country;

public interface DataServiceInterface {
	
		
		
		void saveClient(Client client);
		
		String retrieveUser(String username, String password);
		
		List<Client> findUsersbyUsernameAgeLanguageCountry(String username, int ageStart, int ageEnd, String language, String country);
		
		void updateClient(Client client);
}
