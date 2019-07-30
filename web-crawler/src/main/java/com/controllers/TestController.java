package com.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class TestController {
	
	@RequestMapping("/")
	public String redirectToHomePage(HttpServletResponse response) throws IOException {
		return "You are an authorized user";
	} 
}
 