package com.bhs.springboot.dto;

import com.bhs.springboot.domain.weathers.Weathers;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;

@ToString
@Builder
@Getter
public class WeatherStats {
    private int temperature;
    private int rain;


    private String ulray;
    private String weather;
    private String ondo;
    private String weathericon;
    private String imgicon;
    private String name;

    @Builder
    public WeatherStats(int temperature, int rain, String ulray, String weather, String ondo,
                        String weathericon, String imgicon, String name) {

        this.temperature = temperature;
        this.rain = rain;
        this.ulray = ulray;
        this.weather = weather;
        this.ondo = ondo;
        this.weathericon = weathericon;
        this.imgicon = imgicon;
        this.name = name;
    }

    public Weathers toEntity() {
        return Weathers.builder()
                .temperature(temperature)
                .rain(rain)
                .ulray(ulray)
                .weather(weather)
                .ondo(ondo)
                .weathericon(weathericon)
                .imgicon(imgicon)
                .name(name)
                .build();
    }





}
