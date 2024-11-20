package com.Supra.The_Forecastinator.Service;
import java.util.List;

import com.Supra.The_Forecastinator.Model.WeatherModel;
import com.Supra.The_Forecastinator.View.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weather")
public class WeatherService {

        @GetMapping("/fetchAPI") //GET
        public WeatherResponse fetchAPI() {
            String url = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m";
            RestTemplate restTemplate = new RestTemplate();
            WeatherModel weatherModel;

            try {
                weatherModel = restTemplate.getForObject(url, WeatherModel.class);

                if (weatherModel != null) {
                    List<Double> temperatures = weatherModel.getHourly().getTemperature_2m();
                    double averageTemperature = temperatures.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

                    // Returnera en strukturerad respons
                    return new WeatherResponse(weatherModel.getLatitude(), weatherModel.getLongitude(), averageTemperature);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
