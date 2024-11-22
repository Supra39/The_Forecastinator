package com.Supra.The_Forecastinator.Controller;

import com.Supra.The_Forecastinator.Service.WeatherService;
import com.Supra.The_Forecastinator.View.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current") // get current weather
    public ResponseEntity<WeatherResponse> getCurrentWeather(
            @RequestParam double latitude,
            @RequestParam double longitude) {
        return ResponseEntity.ok(weatherService.getCurrentWeather(latitude, longitude));
    }

    @GetMapping("/forecast") //get upcoming weather
    public ResponseEntity<WeatherResponse> getForecast(
            @RequestParam double latitude,
            @RequestParam double longitude) {
        return ResponseEntity.ok(weatherService.getForecast(latitude, longitude));
    }

    @GetMapping("/historical") //get historial weather
    public ResponseEntity<WeatherResponse> getHistoricalWeather(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam String startDate,
            @RequestParam String endDate) {
        return ResponseEntity.ok(weatherService.getHistoricalWeather(latitude, longitude, startDate, endDate));
    }

}
