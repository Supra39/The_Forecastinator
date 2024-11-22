package com.Supra.The_Forecastinator.Service;

import com.Supra.The_Forecastinator.Model.WeatherModel;
import com.Supra.The_Forecastinator.View.WeatherResponse;

public class WeatherResponseTransformer {
    public static WeatherResponse toCurrentWeatherResponse(WeatherModel weatherData) {
        // Extract current weather from `weatherData`
        // Logic to process `hourly` and return only the current hour's weather
        return new WeatherResponse(
                weatherData.getLatitude(),
                weatherData.getLongitude(),
                weatherData.getHourly().getTemperature_2m().get(0) // Example: First hour's temperature
        );
    }

    public static WeatherResponse toForecastResponse(WeatherModel weatherData) {
        // Extract forecast data (e.g., max/min temperature for upcoming days)
        return new WeatherResponse(
                weatherData.getLatitude(),
                weatherData.getLongitude(),
                0 // Example: placeholder for forecast average temperature
        );
    }

    public static WeatherResponse toHistoricalWeatherResponse(WeatherModel weatherData) {
        // Process historical weather data
        return new WeatherResponse(
                weatherData.getLatitude(),
                weatherData.getLongitude(),
                0 // Example: placeholder for historical data average temperature
        );
    }
}
