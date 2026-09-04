package com.prakhar.ETEjournal.repository;

import com.prakhar.ETEjournal.Entity.User;
import com.prakhar.ETEjournal.Repository.UserRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

@SpringBootTest
public class UserRepositoryImplTests {
    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    @Test
    public void test(){
        assertNotNull(userRepositoryImpl.getUsersForSA());
    }
}
