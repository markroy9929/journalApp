package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private static final String apiKey = "f3804f68e5c41d496443a4bf45cf789f";

    private static final String API = "http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;


    public WeatherResponse getWeather(String city) {
        String finalAPI = API.replace("CITY", city).replace("API_KEY", apiKey);
/*
        EXAMPLE TO SHOW POST API CALL
        String requsetBody = "{\n" +
                "    \"userName\":\"Ram\",\n" +
                "    \"password\":\"Ram\"\n" +
                "}  ";
        HttpEntity<String> httpEntity = new HttpEntity<>(requsetBody);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("key","value");
        User user = User.builder().userName("Ankit").password("Ankit").build();
        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.POST, httpEntity, WeatherResponse.class);
*/

        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET, null, WeatherResponse.class);
//       Deserialization: The process of converting JSON response into corresponding java object
//       Serialization: POJO to JSON
        response.getStatusCode();
        WeatherResponse body = response.getBody();
        return body;
    }

}
