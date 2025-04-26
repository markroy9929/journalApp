package net.engineeringdigest.journalApp.service;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.api.response.QuotesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Slf4j
//@Component
@Service
public class QuotesService {
//    private static final String apiKey = "970L5LdzpYS72f2eMWzSFoXJwBZi1EhPJDrOYqr7ddc68ede";
    private static final String apiKey = "7EEXtdxoFah9xdFCgHwrVUj9DhUZu2spCI3RXaGH85943f17";


    @Autowired
    private RestTemplate restTemplate;

    private static final String API = "https://quotes.rest/qod?category=funny";

    public QuotesResponse getQuoteOfTheDay() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-TheySaidSo-Api-Secret", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<QuotesResponse> response = restTemplate.exchange(API, HttpMethod.GET, entity, QuotesResponse.class);
        response.getStatusCode();
        QuotesResponse body = response.getBody();
//        log.info("QuotesResponse body: " + body);
        return body;
    }

}
