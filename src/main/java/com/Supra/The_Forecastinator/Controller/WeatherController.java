package com.Supra.The_Forecastinator.Controller;

import com.Supra.The_Forecastinator.Model.WeatherRecord;
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

    // Create a new weather record
    @PostMapping("/records")
    public ResponseEntity<WeatherRecord> createWeatherRecord(@RequestBody WeatherRecord weatherRecord) {
        WeatherRecord createdRecord = weatherService.createWeatherRecord(weatherRecord);
        return ResponseEntity.ok(createdRecord);
    }

    // Update an existing weather record
    @PutMapping("/records/{id}")
    public ResponseEntity<WeatherRecord> updateWeatherRecord(
            @PathVariable Long id,
            @RequestBody WeatherRecord weatherRecord) {
        WeatherRecord updatedRecord = weatherService.updateWeatherRecord(id, weatherRecord);
        return ResponseEntity.ok(updatedRecord);
    }

    // Delete a weather record
    @DeleteMapping("/records/{id}")
    public ResponseEntity<String> deleteWeatherRecord(@PathVariable Long id) {
        weatherService.deleteWeatherRecord(id);
        return ResponseEntity.ok("Record with ID " + id + " has been deleted.");
    }

}
