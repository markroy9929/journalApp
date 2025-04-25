package net.engineeringdigest.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private static final String apiKey = "f3804f68e5c41d496443a4bf45cf789f";

    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;


    public String getWeather(String city) {
        String finalAPI = API.replace("CITY", city).replace("API_KEY", apiKey);
        restTemplate.exchange(finalAPI, HttpMethod.GET, null)
    }

}
