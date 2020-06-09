package com.bhs.springboot.service;

import com.bhs.springboot.config.auth.LoginUser;
import com.bhs.springboot.config.auth.dto.SessionUser;
import com.bhs.springboot.dto.AreaStats;
import com.bhs.springboot.dto.WeatherStats;
import lombok.extern.log4j.Log4j2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class WeatherDataService {

    private static String WEATHER_DATA_URL = "http://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EC%98%A4%EB%8A%98%EB%82%A0%EC%94%A8";

    private static String WEATHER_DATA_URL2 = "https://weather.naver.com/rgn/cityWetrMain.nhn";





    public List<WeatherStats> getWeatherDatas(SessionUser user) throws IOException {

        List<WeatherStats> weatherStatsList = new ArrayList<>();
        Document doc = Jsoup.connect(WEATHER_DATA_URL).get();

        Elements contents = doc.select("div.info_data");

        Elements Datacontents = doc.select("li.on.now.merge1");

        Elements tdContents = contents.select("li");

        String temperatureText = contents.select("p.info_temperature span.todaytemp").text().trim();
        String rainText = Datacontents.select("dd.weather_item._dotWrapper span").text().trim();
        String weatherText = tdContents.get(0).text();
        String ondoText = tdContents.get(1).text();
        String ulray = tdContents.get(2).text();
        String usertext = user.getEmail();
        log.info("usertext : "+ usertext);



        int temperatureInt = Integer.parseInt(temperatureText);
        int rainInt = Integer.parseInt(rainText);


        WeatherStats weatherStats = WeatherStats.builder()
                .temperature(temperatureInt)
                .rain(rainInt)
                .weather(weatherText)
                .ondo(ondoText)
                .ulray(ulray)
                .build();



        System.out.println(weatherStats.toString());
        System.out.println("날씨 서비스 끝");
        weatherStatsList.add(weatherStats);
        return weatherStatsList;
    }

    public List<AreaStats> getAreaDatas() throws IOException {

        List<AreaStats> areaStatsList = new ArrayList<>();

        Document doc2 = Jsoup.connect(WEATHER_DATA_URL2).get();

        Elements contents2 = doc2.select("table tbody tr");

        for (Element content2 : contents2) {

            Elements tdContents2 = content2.select("td");


            String thText = content2.select("th").text();
            if(thText.isEmpty()) {
                break;
            }


            String srcText = tdContents2.select("p.icon img").attr("src");
            String ulText = tdContents2.select("ul.text").text();

            AreaStats areaStats = AreaStats.builder()
                    .area(thText)
                    .img(srcText)
                    .weather(ulText)
                    .build();

            System.out.println(areaStats.toString());

            areaStatsList.add(areaStats);

        }

        return areaStatsList;
    }
}