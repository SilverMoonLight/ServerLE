package com.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.dataentity.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

	Client findClientByEmailAndPassword(String email, String password);
	
	Client findClientByEmail(String email);
}
