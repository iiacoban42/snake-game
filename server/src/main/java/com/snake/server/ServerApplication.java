package com.snake.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class that starts the server.
 */
@SpringBootApplication
public class ServerApplication {
    /**
     * Main method that launches the server.
     * @param args array of strings args
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
