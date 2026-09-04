package com.prakhar.ETEjournal.service;

import com.prakhar.ETEjournal.Repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Disabled
    @Test
    public void testFindByUsername() {
        assertNotNull(userRepository.findByUsername("ram"));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "1,1,2",
            "3,4,7",
            "4,5,10"
    })
    public void test (int a, int b, int expected){
        assertEquals(expected, a+b);
    }

    @ParameterizedTest
    @ValueSource (strings = {
            "ram",
            "shyam",
            "prakhar",
            "prakhar2"
    })
    public void test2(String name){
        assertNotNull(userRepository.findByUsername(name), "failed for:-" + name);
    }



}
