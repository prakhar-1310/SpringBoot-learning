package com.prakhar.ETEjournal.Service;

import com.prakhar.ETEjournal.Entity.User;
import com.prakhar.ETEjournal.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;


    // logging
    //private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean saveNewUser(User user) {
        try{
            user.setPassword(encoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        }
        catch (Exception e){
//            logger.error("error while saving user {} :", user.getUsername(), e);
            log.error("error while saving user {} :", user.getUsername(), e);
            log.debug("hii this is debug");
            log.trace("hii this is trace");
            log.info("hii this is info");
            log.warn("hii this is warn");
            return false;
        }

    }

    public void saveNewAdmin(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("ADMIN", "USER"));
        userRepository.save(user);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId myId) {
        userRepository.deleteById(myId);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
