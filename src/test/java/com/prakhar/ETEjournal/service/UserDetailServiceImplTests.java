package com.prakhar.ETEjournal.service;

import com.prakhar.ETEjournal.Entity.User;
import com.prakhar.ETEjournal.Repository.UserRepository;
import com.prakhar.ETEjournal.Service.UserDetailsServiceImpl;
import com.prakhar.ETEjournal.Service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


public class UserDetailServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Mock
    private UserRepository userRepository ;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void loadUserByUsernameTest(){
        when (userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("ram").roles(new ArrayList<>()).password("312eqwd").build());

        UserDetails user = userDetailsServiceImpl.loadUserByUsername("ram");
        assertNotNull(user);
    }




}
