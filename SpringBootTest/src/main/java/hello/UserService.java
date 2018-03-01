package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	private List<User> users;
	
	public List<User> findUserNameOrEmail(String username) {
		List<User> result = users.stream().filter(x -> x.getUsername().equalsIgnoreCase(username)).collect(Collectors.toList());
		
		return result;
	}
	
	@PostConstruct
	private void iniDataForTesting() {
		users = new ArrayList<User>();
		
		User user1 = new User("Frank", "password111", "frank@test.com");
		User user2 = new User("Rachel", "password222", "rachel@test.com");
		User user3 = new User("Brad", "password333", "brad@test.com");
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
	}
}