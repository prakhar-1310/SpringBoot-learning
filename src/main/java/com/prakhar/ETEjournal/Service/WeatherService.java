package com.prakhar.ETEjournal.Service;

import com.prakhar.ETEjournal.api_response.WeatherResponse;
import com.prakhar.ETEjournal.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}")
    private String api; // this is non static

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeatherDescription(String city) {
        WeatherResponse weatherResponse = redisService.get("Weather_of_" + city, WeatherResponse.class);
        if(weatherResponse!=null){
            return weatherResponse;
        }
        String finalAPI = appCache.configMap.get("weather_api").replace("<city>", city).replace("<apiKey>", api);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
        // json to POJO
        WeatherResponse body = response.getBody();
        if(body!=null){
            redisService.set("Weather_of_"+city, body, 300l);
        }
        return body;
    }

}
