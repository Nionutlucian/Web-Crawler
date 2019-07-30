package com.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.model.User;
import com.model.UserLoginDto;
import com.service.ProductService;
import com.service.UserService;


@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	UserService userService;
	HttpServletResponse response;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@RequestBody User user) throws NoSuchAlgorithmException {
		userService.register(user);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody UserLoginDto user) throws IOException, NoSuchAlgorithmException {
		User u = userService.login(user.getEmail(), user.getPassword());
		return u;
	}	
}
