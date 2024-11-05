package com.Supra.The_Forecastinator.Service;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    private final String apiKey = "YOUR_API_KEY";
    private final RestTemplate restTemplate = new RestTemplate();

    public CurrentWeather getCurrentWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        ResponseEntity<CurrentWeather> response = restTemplate.getForEntity(url, CurrentWeather.class);
        return response.getBody();
    }
}
            /* TODO
            * VÄLJ API: OPENWEATHERMAP eller WEATHERBIT
            * IMPLEMENTERA API (ganska stort steg)
            * GÖR PRESENTATIONEN AV API SKIT SNYGG
            * */