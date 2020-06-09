package com.bhs.springboot.web;

import com.bhs.springboot.dto.WearStats;
import com.bhs.springboot.service.WearDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class WearController {


    private final WearDataService wearDataService;

    @GetMapping("/wear")
    public String wear(Model model) throws IOException {

        List<WearStats> wearStatsList = wearDataService.getWearDatas();

        model.addAttribute("wearStats", wearStatsList);



        return "wear";

    }

}

