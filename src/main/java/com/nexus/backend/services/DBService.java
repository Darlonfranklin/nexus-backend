package com.nexus.backend.services;
import com.nexus.backend.domain.User;
import com.nexus.backend.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Configuration
@Service
public class DBService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@PostConstruct
	public void instanceDB() {

		String username = "darlon";
		String password = "123";

		Optional<User> existingUser = userRepository.findByUsername("darlon");
		if (existingUser.isEmpty()) {
			User user = new User();
            user.setUsername(username);
            user.setPassword(encoder.encode(password)); 
            user.setActive(true); 
            userRepository.save(user);
		}
	}
}
