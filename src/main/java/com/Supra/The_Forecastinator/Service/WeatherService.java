package com.Supra.The_Forecastinator.Service;

import com.Supra.The_Forecastinator.Model.WeatherModel;
import com.Supra.The_Forecastinator.View.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//Changed class to only handle logic of interacting with the weather API.
//WeatherService now handles API interaction and Fetches raw data from the OPEN-Meteo API for various use cases.

@Service
public class WeatherService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String BASE_URL = "https://api.open-meteo.com/v1/forecast";

    public WeatherModel fetchWeatherData(double latitude, double longitude, String parameters) {
        String url = String.format("%s?latitude=%f&longitude=%f&%s&timezone=auto", BASE_URL, latitude, longitude, parameters);
        return restTemplate.getForObject(url, WeatherModel.class);
    }

    public WeatherResponse getCurrentWeather(double latitude, double longitude) {
        String parameters = "hourly=temperature_2m,relative_humidity_2m,wind_speed_10m,precipitation";
        WeatherModel weatherData = fetchWeatherData(latitude, longitude, parameters);

        // Logic to extract and return current hour's data (e.g., temperature, precipitation)
        return WeatherResponseTransformer.toCurrentWeatherResponse(weatherData);
    }

    public WeatherResponse getForecast(double latitude, double longitude) {
        String parameters = "daily=temperature_2m_max,temperature_2m_min,precipitation_sum";
        WeatherModel weatherData = fetchWeatherData(latitude, longitude, parameters);

        // Logic to structure forecast data for coming days
        return WeatherResponseTransformer.toForecastResponse(weatherData);
    }

    public WeatherResponse getHistoricalWeather(double latitude, double longitude, String startDate, String endDate) {
        String parameters = String.format("start_date=%s&end_date=%s&daily=temperature_2m_max,temperature_2m_min,precipitation_sum", startDate, endDate);
        WeatherModel weatherData = fetchWeatherData(latitude, longitude, parameters);

        // Logic to process historical weather data
        return WeatherResponseTransformer.toHistoricalWeatherResponse(weatherData);
    }

}
