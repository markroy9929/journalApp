package net.engineeringdigest.journalApp.service;
import lombok.extern.slf4j.Slf4j;
import net.engineeringdigest.journalApp.api.response.QuotesResponse;
import net.engineeringdigest.journalApp.api.response.WeatherResponse;

import net.engineeringdigest.journalApp.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

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
            log.info("QuotesResponse found in Redis Cloud");
            return quotesResponse;
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-TheySaidSo-Api-Secret", apiKey);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            try{
                log.info("API call to Quotes Service");
                ResponseEntity<QuotesResponse> response = restTemplate.exchange(API, HttpMethod.GET, entity, QuotesResponse.class);
                response.getStatusCode();
                QuotesResponse body = response.getBody();
                log.info("QuotesResponse body: {}", body);
                if (body != null) {
                    redisService.set("QuoteOfTheDay", body, 9999l);
                }
                return body;
            } catch (Exception e) {
                log.error("Failed to fetch quote from API: {}", e.getMessage(), e);

                // Fallback Quote if API fails or response is invalid
                QuotesResponse fallback = new QuotesResponse();
                QuotesResponse.Contents contents = new QuotesResponse.Contents();
                QuotesResponse.Quote quote = new QuotesResponse.Quote();
                quote.setQuote("Keep going, everything you need will come to you at the perfect time.");

                ArrayList<QuotesResponse.Quote> quoteList = new ArrayList<>();
                quoteList.add(quote);
                contents.setQuotes(quoteList);
                fallback.setContents(contents);

                return fallback;
            }

        }
    }
}
