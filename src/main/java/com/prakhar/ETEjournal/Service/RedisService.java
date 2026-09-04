package com.prakhar.ETEjournal.Service;

import com.prakhar.ETEjournal.api_response.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    public <T> T get(String key,  Class<T>entityClass){
        try {
            Object o = redisTemplate.opsForValue().get(key);
            if (o == null) {
                return null;
            }
            ObjectMapper mapper = new ObjectMapper();
            T entity = mapper.readValue(o.toString(), entityClass);
            return entity;
        }
        catch (Exception e) {
            log.error("redis Exception ", e);
            return null;
        }

    }

    public void set(String key, Object value, Long expireTime){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonValue = mapper.writeValueAsString(value);
            redisTemplate.opsForValue().set(key, jsonValue, expireTime, TimeUnit.SECONDS);
        }
        catch (Exception e) {
            log.error("redis Exception ", e);
        }
    }
}
