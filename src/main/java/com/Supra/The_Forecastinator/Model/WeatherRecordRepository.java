package com.Supra.The_Forecastinator.Model;

import com.Supra.The_Forecastinator.Model.WeatherRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interface to interact with DB

@Repository
public interface WeatherRecordRepository extends JpaRepository<WeatherRecord, Long> {
    // Additional query methods (if needed) can be defined here
}
