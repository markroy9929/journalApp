package net.engineeringdigest.journalApp.api.response;

import java.util.ArrayList;
import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

public class WeatherResponse{
    private Request request;
    private Location location;
    private Current current;

    public class AirQuality{
        private String co;
        private String no2;
        private String o3;
        private String so2;
        private String pm2_5;
        private String pm10;
        private String us-epa-index;
        private String gb-defra-index;
    }

    public class Astro{
        private String sunrise;
        private String sunset;
        private String moonrise;
        private String moonset;
        private String moon_phase;
        private int moon_illumination;
    }

    public class Current{
        private String observation_time;
        private int temperature;
        private int weather_code;
        private List<String> weather_icons;
        private ArrayList<String> weather_descriptions;
        private Astro astro;
        private AirQuality air_quality;
        private int wind_speed;
        private int wind_degree;
        private String wind_dir;
        private int pressure;
        private int precip;
        private int humidity;
        private int cloudcover;
        private int feelslike;
        private int uv_index;
        private int visibility;
        private String is_day;
    }

    public class Location{
        private String name;
        private String country;
        private String region;
        private String lat;
        private String lon;
        private String timezone_id;
        private String localtime;
        private int localtime_epoch;
        private String utc_offset;
    }

    public class Request{
        private String type;
        private String query;
        private String language;
        private String unit;
    }
}
