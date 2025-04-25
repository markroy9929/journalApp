package net.engineeringdigest.journalApp.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuotesResponse {
    private Contents contents;

    @Getter
    @Setter
    public static class Contents{
        private ArrayList<Quote> quotes;
    }

    @Getter
    @Setter
    public static class Quote{
        private String quote;
    }
}
