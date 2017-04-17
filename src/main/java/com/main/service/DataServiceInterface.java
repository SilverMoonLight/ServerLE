package com.main.service;

import com.main.dataentity.Client;

public interface DataServiceInterface {
	
		Client findClientByEmailAndPassword(String email, String password);
		
		void saveClient(Client client);
}
