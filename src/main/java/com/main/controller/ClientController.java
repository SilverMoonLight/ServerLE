package com.main.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.dataentity.Client;
import com.main.service.DataServiceInterface;
import com.main.transferobject.ClientSearchTO;
import com.main.transferobject.ClientTO;

@RestController
@RequestMapping("/user")
public class ClientController {

	private Logger logger = Logger.getLogger(ClientController.class);

	@Autowired
	DataServiceInterface dataservice;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String loginUser(@RequestBody ClientTO clientTO) {
		logger.info("Logging in...");
		logger.info("User name " + clientTO.getEmail() + " Password " + clientTO.getPassword());
		String token = dataservice.retrieveUser(clientTO.getEmail(), clientTO.getPassword());
		if (token != null) {
			logger.info("token " + token);
			return token;
		} else {
			token = "no user found";
			return token;
		}
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ClientTO createMessage() {
		ClientTO clientTO = new ClientTO("jon", 0, "red", "yo", "jon", null, "good", null, null);
		return clientTO;
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Client createCreateUser(@RequestBody ClientTO clientTO) {
		logger.info("Creating user...");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Client client = new Client(clientTO.getEmail(), encoder.encode(clientTO.getPassword()), clientTO.getFirstName(), 
				clientTO.getLastName(), clientTO.getRole(), clientTO.getCountry(), clientTO.getLanguage(), clientTO.getAge(), clientTO.getBio());
		logger.info("Add user " + client.toString());
		dataservice.saveClient(client);
		logger.info("user was added");
		return client;
	}
	
	@RequestMapping(value ="/updateUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Client updateUser(@RequestBody ClientTO clientTO){
		logger.info("Updating user");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Client client = new Client(clientTO.getEmail(), encoder.encode(clientTO.getPassword()), clientTO.getFirstName(), 
				clientTO.getLastName(), clientTO.getRole(), clientTO.getCountry(), clientTO.getLanguage(), clientTO.getAge(), clientTO.getBio());
		dataservice.updateClient(client);
		logger.info("updated client");
		return client;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public List<Client> searchUsers(@RequestBody ClientSearchTO clientSearchTO) {
		logger.info("Searching for user");		
		List<Client> users = dataservice.findUsersbyUsernameAgeLanguageCountry(clientSearchTO.getEmail(),
				clientSearchTO.getStartAge(), clientSearchTO.getEndAge(), clientSearchTO.getLanguage(),
				clientSearchTO.getCountry());
		logger.info("found " + users.size() + " users");
		return users;
	}
}
