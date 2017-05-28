package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.config.JWTAuthenticationToken;
import com.main.config.JWTUtils;
import com.main.dataentity.Client;
import com.main.repo.ClientRepo;

@Service("dataService")
@Transactional
public class DataService implements DataServiceInterface {

	private Logger logger = Logger.getLogger(DataService.class);

	@Autowired
	ClientRepo clientRepo;

	@Autowired
	@Qualifier("brcypt")
	BCryptPasswordEncoder encoder;

	@Override
	public String retrieveUser(String username, String password) {
		logger.info("Data Service password, email: " + username + " " + password);

		Client client = clientRepo.findClientByEmail(username);
		if (client != null && encoder.matches(password, client.getPassword())) {
			logger.info("user found");
			JWTUtils jwtUtils = new JWTUtils();
			String token = jwtUtils.createJWT(client.getId() + "", "LE token", 100000, client);
			return token;
		} else {
			return null;
		}
	}

	@Override
	public void saveClient(Client client) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Client> findUsersbyUsernameAgeLanguageCountry(String username, int ageStart, int ageEnd,
			String language, String country) {
		ArrayList<Client> users = null;
		
		if (ageStart == -1 && ageEnd == -1) {
			logger.info("finding users without age");
			users = clientRepo.findClientByEmailLikeAndLanguageLikeAndCountryLike(username, language, country);
		} else {
			logger.info("finding users with age");
			users = clientRepo.findClientAgeBetween(ageStart, ageEnd);
			logger.info("users found list size age " + users.size());
			ArrayList<Client> duplicateUsers = clientRepo.findClientByEmailLikeAndLanguageLikeAndCountryLike(username,
					language, country);
			Set<Client> cleanList = null;
			
			int listSize = users.size() >= duplicateUsers.size() ? users.size(): duplicateUsers.size();
			
			for(int user = 0; user < listSize; user++){
				cleanList.add(duplicateUsers.get(user));
				cleanList.add(users.get(user));
			}
			logger.info("users found clean list size" + cleanList.size());
			users.clear();
			users.addAll(cleanList);
		}

		return users;
	}

	@Override
	public void updateClient(Client client) {
		clientRepo.saveAndFlush(client);
		
	}

}
