package com.main.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.dataentity.Client;
import com.main.service.DataService;
import com.main.service.DataServiceInterface;
import com.main.transferobject.ClientTO;

@RestController
@RequestMapping("/user")
public class ClientController {
	
	private Logger logger = Logger.getLogger(ClientController.class);
	
	
	
	@RequestMapping(value ="/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Client loginUser(@RequestBody ClientTO clientTO) {
		logger.info("Logging in...");
		logger.info("User name" + clientTO.getEmail() + " Password " +  clientTO.getPassword());
		//userService.retrieveUser(clientTO.getEmail(), clientTO.getPassword());
		/*if (client != null) 
			logger.info("Logged in User +" + client.toString() );
		else
			logger.info("No user found");*/
		return null;
	}
	
	@RequestMapping(value ="/message", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Client createMessage(@RequestBody ClientTO clientTO) {
		logger.info("User name" + clientTO.getEmail() + " Password " +  clientTO.getPassword());
		return null;
	}
	
	@RequestMapping(value ="/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Client createCreateUser(@RequestBody ClientTO clientTO) {
		logger.info("Creating user...");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Client client = new Client(clientTO.getEmail(), encoder.encode(clientTO.getPassword()), clientTO.getFirstName(), clientTO.getLastName(), clientTO.getRole(), clientTO.getBio());
		logger.info("User +" + client.toString() );
		//dataService.saveClient(client);
		return client;
	}
}
