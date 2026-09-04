package com.prakhar.ETEjournal.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    @Disabled
    public void test() {
        redisTemplate.opsForValue().set("email", "email@gmail.com");

        Object value = redisTemplate.opsForValue().get("email");
        assertNotNull(value);
        System.out.println(value);
    }
}
