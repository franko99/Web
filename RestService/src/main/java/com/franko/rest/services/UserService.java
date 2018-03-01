package com.franko.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.franko.rest.models.User;

@Service
public class UserService {
	
	private List<User> users;
	
	public List<User> findByUserNameOrEmail(String username) {
		List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
		
		return result;
	}
	
	@PostConstruct
	private void iniDataForTesting() {
		users = new ArrayList<User>();
		
		User user1 = new User("Frank", "password111", "frank@test.com");
		User user2 = new User("Kylie", "password222", "kylie@test.com");
		User user3 = new User("Admin", "admin", "admin@franko.com");
		User user4 = new User("Frank", "password123", "frank@test.com");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
	}
}
