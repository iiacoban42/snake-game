package com.snake.server.controllers;

import com.snake.server.repositories.User;
import com.snake.server.repositories.UserRepository;
import com.snake.server.requests.LogInRequest;
import com.snake.server.requests.SignUpRequest;
import com.snake.server.requests.UserResponse;

import java.util.Optional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class to make mappings.
 */
@Controller
@RequestMapping("/api/user")
public class UserApi {
    @Autowired
    transient UserRepository userRepository;

    /**
     * Mapping to login to the system.
     * @param logInRequest request class with username and psswd.
     * @return Response Entity that goes to the client.
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@Valid @RequestBody LogInRequest logInRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(logInRequest.getUsername());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().compareTo(logInRequest.getPassword()) == 0) {
                return new ResponseEntity<>("Success!", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Wrong password!",
                        HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Mapping to sign up to the system.
     * @param signUpRequest Request with username and password.
     * @return ResponseEntity that goes to the client.
     */
    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpRequest signUpRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(signUpRequest.getUsername());
        if (optionalUser.isPresent()) {
            return new ResponseEntity<>("User with this username already exists!",
                    HttpStatus.CONFLICT);
        }
        User user = new User(signUpRequest.getUsername(), signUpRequest.getPassword());
        userRepository.save(user);
        return new ResponseEntity<>("User created successfully!", HttpStatus.OK);
    }

    /**
     * Mapping to get info on specific user.
     * @param username username of a user.
     * @return ResponseEntity that mainly contains max score.
     */
    @PostMapping("/userinfo")
    public ResponseEntity<UserResponse> getInfo(@Valid @RequestBody String username) {
        User user = userRepository.findByUsername(username).get();
        UserResponse response = new UserResponse(user.getUsername(), user.getMaxscore().intValue());
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
}
