package com.snake.server.controllers;

import com.snake.server.domain.User;
import com.snake.server.domain.UserInfo;
import com.snake.server.repositories.UserRepository;
import com.snake.server.requests.LogInRequest;
import com.snake.server.requests.SignUpRequest;
import com.snake.server.responses.UserResponse;

import java.util.Set;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class to make mappings.
 */
@Controller
@RequestMapping("/api/user")
@SuppressWarnings("PMD")
public class UserApi {

    @Autowired
    transient UserRepository userRepository;

    public UserApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Mapping to login to the system.
     * @param logInRequest request class with username and psswd.
     * @return Response Entity that goes to the client.
     */
    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@Valid @RequestBody LogInRequest logInRequest) {
        User user = userRepository.findByUsername(logInRequest.getUsername()).orElse(null);
        if (user != null) {
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
        User found = userRepository.findByUsername(signUpRequest.getUsername()).orElse(null);
        if (found != null) {
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
    public ResponseEntity<?> getInfo(@Valid @RequestBody String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
        UserResponse response = new UserResponse(user.getUsername(), user.getMaxscore().intValue());
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    /**
     * Get mapping to get highest scores.
     * @return ResponseEntity containing top-5 scores
     */
    @GetMapping("/topscores")
    public ResponseEntity<?> getTopScores() {
        Set<UserInfo> userInfos = userRepository.getTopScores();
        UserResponse[] responses = new UserResponse[userInfos.size()];
        int i = 0;
        for (UserInfo ui : userInfos) {
            responses[i] = new UserResponse(ui.getUsername(), ui.getScore());
            i++;
        }
        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }
}
