package com.prakhar.ETEjournal.Controller;

import com.prakhar.ETEjournal.Entity.User;
import com.prakhar.ETEjournal.Repository.UserRepository;
import com.prakhar.ETEjournal.Service.UserService;
import com.prakhar.ETEjournal.Service.WeatherService;
import com.prakhar.ETEjournal.api_response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WeatherService weatherService;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User temp = userService.findByUsername(username);
        if (temp != null) {
            temp.setPassword(user.getPassword());
            temp.setUsername(user.getUsername());
            userService.saveNewUser(temp);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @DeleteMapping
    public ResponseEntity<?> deleteUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        userRepository.deleteByUsername(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/greeting")
    public ResponseEntity<?> greeting() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        WeatherResponse weatherResponse = weatherService.getWeatherDescription("Mumbai");
        String greeting ="";
        if(weatherResponse!=null) {
            greeting = " Weather feels like " + weatherResponse.getCurrent().getFeelslike();
        }
        return new ResponseEntity<>("Hii " + username + greeting, HttpStatus.OK);
    }



}
