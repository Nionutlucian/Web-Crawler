package com.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.Role;
import com.model.User;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.security.PasswordMD5;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	PasswordMD5 passwordEncoder = new PasswordMD5();

	@Transactional
	public void register(User user) throws NoSuchAlgorithmException {
		Role role = roleRepository.findByName("USER");
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		if (user.getEmail() != null && user.getName() != null && user.getPassword() != null
				&& user.getAdress() != null) {

			user.setRoles(roles);
			user.setPassword(passwordEncoder.encodeMD5(user.getPassword()));
			userRepository.save(user);
		}
	}

	@Transactional
	public User login(String email, String password) throws IOException, NoSuchAlgorithmException {
		User userAuth = userRepository.loginQuery(email, passwordEncoder.encodeMD5(password));
		
		if (userAuth != null) {
			Set<Role> roles = userAuth.getRoles();
			ArrayList<String> rolesAr = new ArrayList<>();
			for(Role r : roles) {
				rolesAr.add(r.getName());
			}
			if (rolesAr.contains("USER")) {
				System.out.println("Login as USER");
			} else if (rolesAr.contains("ADMIN")) {
				System.out.println("Login as ADMIN");
			}
		}else {
			userAuth = new User();
			userAuth.setAdress("Username or password incorect!");
			userAuth.setEmail("Username or password incorect!");
			userAuth.setName("Username or password incorect!");
			userAuth.setPassword("Username or password incorect!");
		}
		System.out.println("email: " + userAuth.getEmail());
		return userAuth;
	}

}
