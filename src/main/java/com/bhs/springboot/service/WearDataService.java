package com.bhs.springboot.service;


import com.bhs.springboot.dto.WearStats;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WearDataService {

    private static String WEAR_DATA_URL = "https://www.musinsa.com/index.php?m=street&ordw=submitdate&gender=m";
    private static String WEAR_DATA_URL2 = "https://www.musinsa.com/index.php?m=street&ordw=submitdate&gender=f";
    private static String WEAR_DATA_URL3 = "https://www.musinsa.com/index.php?m=shopstaff&gender=m&ordw=d_regis&p=1";
    private static String WEAR_DATA_URL4 = "https://www.musinsa.com/index.php?m=shopstaff&ordw=d_regis&gender=f";




    public List<WearStats> getWearDatas() throws IOException {

        List<WearStats> wearStatsList = new ArrayList<>();
        Document doc = Jsoup.connect(WEAR_DATA_URL).get();
        Document doc2 = Jsoup.connect(WEAR_DATA_URL2).get();
        Document doc3 = Jsoup.connect(WEAR_DATA_URL3).get();
        Document doc4 = Jsoup.connect(WEAR_DATA_URL4).get();

        Elements contents = doc.select("ul.snap-article-list.boxed-article-list.article-list.center.list");
        Elements contents2 = doc2.select("ul.snap-article-list.boxed-article-list.article-list.center.list");
        Elements contents3 = doc3.select("ul.snap-article-list.boxed-article-list.article-list.center.list");
        Elements contents4 = doc4.select("ul.snap-article-list.boxed-article-list.article-list.center.list");



            WearStats wearStats = WearStats.builder()
                    .photo(contents.select("img").attr("src"))
                    .photo2(contents2.select("img").attr("src"))
                    .mphoto(contents3.select("img").attr("src"))
                    .gphoto(contents4.select("img").attr("src"))
                    .build();

        wearStatsList.add(wearStats);
            System.out.println(wearStats.toString());


        return wearStatsList;

    }

}
