package com.snake.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Class to start the server.
 */
@SpringBootApplication
public class ServerApplication {

	/**
	 * Method starts the server.
	 * @param args arguments of main method.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}
