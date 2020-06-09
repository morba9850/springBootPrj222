package com.bhs.springboot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;



@ToString
@Builder
@Getter

public class WearStats {
    private String photo;
    private String photo2;
    private String gphoto;
    private String mphoto;

}
