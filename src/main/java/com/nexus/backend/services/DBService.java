package com.nexus.backend.services;

import com.nexus.backend.domain.User;
import com.nexus.backend.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

		Optional<User> existingUser = userRepository.findByUsername("darlon");
		if (!existingUser.isPresent()) {
			User user = new User(null, "darlon", encoder.encode("123"));
			userRepository.save(user);
		}
	}


}
