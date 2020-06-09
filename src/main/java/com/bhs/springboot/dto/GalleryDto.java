package com.bhs.springboot.dto;

import com.bhs.springboot.domain.Gallery.GalleryEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GalleryDto {
    private Long id;
    private String title;
    private String filePath;
    private String name;


    public GalleryEntity toEntity(){
        GalleryEntity build = GalleryEntity.builder()
                .id(id)
                .title(title)
                .filePath(filePath)
                .name(name)
                .build();
        return build;
    }

    @Builder
    public GalleryDto(Long id, String title, String filePath, String name) {
        this.id = id;
        this.title = title;
        this.filePath = filePath;
        this.name = name;
    }
}