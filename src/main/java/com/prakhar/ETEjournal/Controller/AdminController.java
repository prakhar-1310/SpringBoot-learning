package com.prakhar.ETEjournal.Controller;

import com.prakhar.ETEjournal.Entity.User;
import com.prakhar.ETEjournal.Service.UserService;
import com.prakhar.ETEjournal.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppCache appCache;

    @GetMapping("/all-users")
    public ResponseEntity<?>getAllUsers(){
        List<User> all = userService.getAll();
        if(all != null  && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/create-admin-user")
    public void createAdminUser(@RequestBody User user) {
        userService.saveNewAdmin(user);
    }

    @GetMapping("/refresh-cache")
    public void refreshCache(){
        appCache.init();
    }
}
