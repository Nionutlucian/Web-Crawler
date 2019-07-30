package com.java.webcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.controllers", "com.repository", "com.service"})
@EnableJpaRepositories("com.repository")
@EntityScan("com.model")
public class WebCrawlerApplication {

	public static void main(String[] args)  {
		SpringApplication.run(WebCrawlerApplication.class, args);
	}
}
 