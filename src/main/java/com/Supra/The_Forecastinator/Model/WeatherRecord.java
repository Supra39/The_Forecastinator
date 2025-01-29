package com.Supra.The_Forecastinator.Model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "weather_records") //this maps this class to my table in db
public class WeatherRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false) //this annotation allows me to customize how a column is constrained, in this case the column cannot be empty
    private Long id;

    @NotBlank(message = "City cannot be blank or null. Please enter a valid city")
    @Column(nullable = false)
    private String city;
    @NotNull(message = "Date cannot be null. Please provide a valid date.")
    @Column(nullable = false)
    private LocalDate date;
    @NotNull(message = "Temperature cannot be null. Please provide a valid temperature.")
    @Column(nullable = false)
    private double temperature;
    @NotNull(message = "Humidity cannot be null. Please provide a valid Humidity.")
    @Column(nullable = false)
    private double humidity;

    // Getters and Setters (if not already present)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
