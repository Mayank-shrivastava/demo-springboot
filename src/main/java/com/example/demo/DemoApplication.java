package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		// Configure Dotenv to load environment variables from the .env file
		Dotenv dotenv = Dotenv.configure()
				.ignoreIfMissing() // Ignore if .env file is missing
				.load();

		// Set the system property for the server port using the environment variable
		// For single value
		// String serverPort = dotenv.get("SPRING_SERVER_PORT", "8080"); // Default to 8080 if not set
		// System.setProperty("server.port", serverPort);
		
		// for all values
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		System.out.println("Server port set to: " + System.getProperty("PORT"));

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Your code here
		System.out.println("Hello, Spring Boot!");
	}
}
