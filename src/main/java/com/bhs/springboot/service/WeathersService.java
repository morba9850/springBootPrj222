package com.bhs.springboot.service;


import com.bhs.springboot.domain.weathers.WeathersRepository;
import com.bhs.springboot.dto.WeatherStats;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

//데이터베이스에 데이터 넣기
@RequiredArgsConstructor
@Service
public class WeathersService {
    private final WeathersRepository weathersRepository;

    @Transactional
    public Long save(WeatherStats weatherStats) {
        return weathersRepository.save(weatherStats.toEntity()).getId();
    }




}
