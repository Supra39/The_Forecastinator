package com.Supra.The_Forecastinator.View;

        import java.util.List;

    public class WeatherResponse {
        private double latitude;
        private double longitude;
        private double averageTemperature;

        public WeatherResponse(double latitude, double longitude, double averageTemperature) {
            this.latitude = latitude;
            this.longitude = longitude;
            this.averageTemperature = averageTemperature;
        }

        // Getters och Setters
        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getAverageTemperature() {
            return averageTemperature;
        }

        public void setAverageTemperature(double averageTemperature) {
            this.averageTemperature = averageTemperature;
        }
    }

