package com.nexus.backend.services;
import com.nexus.backend.domain.User;
import com.nexus.backend.repositories.UserRepository;
import com.nexus.backend.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepository.findByUsername(username);
		if (userOptional.isPresent()) {
			return new UserSS(userOptional.get().getId(), userOptional.get().getUsername(), userOptional.get().getPassword());
		}
		throw new UsernameNotFoundException(username);
	}

}
