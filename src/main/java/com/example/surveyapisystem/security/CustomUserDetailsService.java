package com.example.surveyapisystem.security;

import com.example.surveyapisystem.entity.User;
import com.example.surveyapisystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Transactional
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// Let people login with either username or email
		User user = userRepository.findByUsername(username)
				.orElseThrow(() ->
						new UsernameNotFoundException("User not found with username : " + username)
				);

		return UserPrincipal.create(user);
	}

	// This method is used by JWTAuthenticationFilter
	@Transactional
	public UserDetails loadUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(
				() -> new UsernameNotFoundException("User not found with id : " + id)
		);

		return UserPrincipal.create(user);
	}
}
