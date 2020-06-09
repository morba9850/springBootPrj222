//날씨데이터 넣으려구 dto 만듬
package com.bhs.springboot.domain.weathers;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Weathers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int temperature;
    private int rain;

    private String ulray;

    private String weather;

    private String ondo;

    private String weathericon;

    private String imgicon;

    private String name;

    @Builder
    public Weathers(int temperature, int rain, String ulray, String weather, String ondo,
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



}
