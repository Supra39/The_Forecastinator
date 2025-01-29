package com.Supra.The_Forecastinator.Controller;

import com.Supra.The_Forecastinator.Model.WeatherRecord;
import com.Supra.The_Forecastinator.Service.WeatherService;
import com.Supra.The_Forecastinator.View.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current/{latitude}/{longitude}") // get current weather, updated to use PathVariable to make the URL more intuitive to write
    public ResponseEntity<?> getCurrentWeather( //changed to ResponseEntity<?> from ResponseEntity<WeatherResponse>
            @PathVariable double latitude,
            @PathVariable double longitude) {
        try { //added error handling, and appropriate status codes
            WeatherResponse response = weatherService.getCurrentWeather(latitude, longitude);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching current weather.");
        }
    }

    @GetMapping("/forecast/{latitude}/{longitude}") //get upcoming weather, updated to use PathVariable to make the URL more intuitive to write
    public ResponseEntity<?> getForecast(
            @PathVariable double latitude,
            @PathVariable double longitude) {
        try {
            WeatherResponse response = weatherService.getForecast(latitude, longitude);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching forecast.");
        }
    }

    @GetMapping("/historical/{latitude}/{longitude}/{startDate}/{endDate}") //get historial weather, updated to use PathVariable to make the URL more intuitive to write
    public ResponseEntity<?> getHistoricalWeather(
            @PathVariable double latitude,
            @PathVariable double longitude,
            @PathVariable String startDate,
            @PathVariable String endDate) {
        try {
            WeatherResponse response = weatherService.getHistoricalWeather(latitude, longitude, startDate, endDate);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching historical weather.");
        }
    }

    // Create a new weather record
    @PostMapping("/records")
    public ResponseEntity<?> createWeatherRecord(@RequestBody WeatherRecord weatherRecord) {
        try {
        WeatherRecord createdRecord = weatherService.createWeatherRecord(weatherRecord);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecord);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input data.");
    }
}

    // Update an existing weather record
    @PutMapping("/records/{id}")
    public ResponseEntity<?> updateWeatherRecord(
            @PathVariable Long id,
            @RequestBody WeatherRecord weatherRecord) {
        Optional<WeatherRecord> updatedRecord = weatherService.updateWeatherRecord(id, weatherRecord);
        if (updatedRecord.isPresent()) {
            return ResponseEntity.ok(updatedRecord.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Weather record not found.");
        }
    }

    // Delete a weather record
    @DeleteMapping("/records/{id}")
    public ResponseEntity<String> deleteWeatherRecord(@PathVariable Long id) {
        boolean isDeleted = weatherService.deleteWeatherRecord(id);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Weather record not found.");
        }
    }
}
