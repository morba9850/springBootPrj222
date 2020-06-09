package com.bhs.springboot.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class AreaStats {

    private String area;
    private String weather;
    private String img;



}
