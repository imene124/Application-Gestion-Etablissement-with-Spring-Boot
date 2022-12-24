package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
//required declaration pour etre un config server
@EnableConfigServer
public class ConfigService1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigService1Application.class, args);
	}

}
