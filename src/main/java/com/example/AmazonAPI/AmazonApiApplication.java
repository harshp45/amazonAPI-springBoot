package com.example.AmazonAPI;

import com.example.AmazonAPI.controllers.UserController;
import com.example.AmazonAPI.controllers.ProductController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmazonApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonApiApplication.class, args);
	}

}
