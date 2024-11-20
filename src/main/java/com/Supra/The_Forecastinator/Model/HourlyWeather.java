package com.Supra.The_Forecastinator.Model;

import java.util.List;

public class HourlyWeather {
    public List<Double> temperature_2m; //subject to change


    //get
    public List<Double> getTemperature_2m() {
        return temperature_2m;
    }
    //set
    public void setTemperature_2m(List<Double> temperature_2m) {
        this.temperature_2m = temperature_2m;
    }
}