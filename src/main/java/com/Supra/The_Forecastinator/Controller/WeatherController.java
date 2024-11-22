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
    //changed the class to use @PathVariable istead of @RequestParam, in my case none of the variables are optional so it makes more sense to only use @PathVariable, to make the URL easier to type.
    @GetMapping("/current/{latitude}/{longitude}") // get current weather, updated to use PathVariable to make the URL more intuitive to write
    public ResponseEntity<WeatherResponse> getCurrentWeather(
            @PathVariable double latitude,
            @PathVariable double longitude) {
        return ResponseEntity.ok(weatherService.getCurrentWeather(latitude, longitude));
    }

    @GetMapping("/forecast/{latitude}/{longitude}") //get upcoming weather, updated to use PathVariable to make the URL more intuitive to write
    public ResponseEntity<WeatherResponse> getForecast(
            @PathVariable double latitude,
            @PathVariable double longitude) {
        return ResponseEntity.ok(weatherService.getForecast(latitude, longitude));
    }

    @GetMapping("/historical/{latitude}/{longitude}/{startDate}/{endDate}") //get historial weather, updated to use PathVariable to make the URL more intuitive to write
    public ResponseEntity<WeatherResponse> getHistoricalWeather(
            @PathVariable double latitude,
            @PathVariable double longitude,
            @PathVariable String startDate,
            @PathVariable String endDate) {
        return ResponseEntity.ok(weatherService.getHistoricalWeather(latitude, longitude, startDate, endDate));
    }

}
