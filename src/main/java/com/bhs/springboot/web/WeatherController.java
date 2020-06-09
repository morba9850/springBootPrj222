package com.bhs.springboot.web;


import com.bhs.springboot.config.auth.LoginUser;
import com.bhs.springboot.config.auth.dto.SessionUser;
import com.bhs.springboot.dto.AreaStats;
import com.bhs.springboot.dto.WeatherStats;
import com.bhs.springboot.dto.postDto.PostsSaveRequestDto;
import com.bhs.springboot.service.WeatherDataService;
import com.bhs.springboot.service.WeathersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class WeatherController {

    private final WeatherDataService weatherDataService;
    private final WeathersService weathersService;

    @GetMapping("/weather")
    public String weather(Model model, @LoginUser SessionUser user) throws IOException {


        List<WeatherStats> weatherStatsList = weatherDataService.getWeatherDatas(user);
        List<AreaStats> areaStatsList = weatherDataService.getAreaDatas();

        try{
            Long id = weathersService.save(weatherStatsList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }


        model.addAttribute("weatherStats", weatherStatsList);
        model.addAttribute("areaStats", areaStatsList);

        System.out.println(areaStatsList);
        System.out.println("끝");



        return "weather";
    }


    //데이터베이스에 데이터넣기
    @PostMapping("/weather")
    public Long save(@RequestBody WeatherStats requestDto)
    {
        return weathersService.save(requestDto);
    }



}