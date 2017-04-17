package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.dataentity.Client;
import com.main.repo.ClientRepo;

@Service
@Transactional
public class DataService implements DataServiceInterface {
	
	@Autowired
	ClientRepo clientRepo;

	@Override
	public Client findClientByEmailAndPassword(String email, String password) {
		
		return clientRepo.findClientByEmailAndPassword(email, password);
	}

	@Override
	public void saveClient(Client client) {
		clientRepo.save(client);
	}

}
