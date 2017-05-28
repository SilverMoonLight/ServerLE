package com.main.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.dataentity.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

	Client findClientByEmailAndPassword(String email, String password);
	
	Client findClientByEmail(String email);
	
	ArrayList<Client> findClientByEmailLikeAndLanguageLikeAndCountryLike(String email, String language, String country);
	
	ArrayList<Client> findClientAgeBetween(int start, int end);
}
