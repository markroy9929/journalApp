package net.engineeringdigest.journalApp.service;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.api.response.QuotesResponse;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;
import net.engineeringdigest.journalApp.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//@Slf4j
//@Component
@Slf4j
@Service
public class QuotesService {
    @Value("${quotes.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisService redisService;

    private static final String API = "https://quotes.rest/qod?category=inspire";

    public QuotesResponse getQuoteOfTheDay() {
        QuotesResponse quotesResponse = redisService.get("QuoteOfTheDay", QuotesResponse.class);
        if (quotesResponse != null) {
            return quotesResponse;
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-TheySaidSo-Api-Secret", apiKey);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            ResponseEntity<QuotesResponse> response = restTemplate.exchange(API, HttpMethod.GET, entity, QuotesResponse.class);
            response.getStatusCode();
            QuotesResponse body = response.getBody();
//            log.info("QuotesResponse body: " + body);
            if (body != null) {
                redisService.set("QuoteOfTheDay", body, 900l);
            }
            return body;
        }
    }
}
