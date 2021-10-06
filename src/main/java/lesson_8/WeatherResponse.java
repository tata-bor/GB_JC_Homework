package lesson_8;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {
    public String WeatherText;
    public lesson_7.Temperature Temperature;
    public String LocalObservationDateTime;
}

