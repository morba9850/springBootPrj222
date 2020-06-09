package com.bhs.springboot.domain.Gallery;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "gallery")
public class GalleryEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;
    private String name;

    @Column(columnDefinition = "TEXT")
    private String filePath;

    @Builder
    public GalleryEntity(Long id, String title, String filePath, String name) {
        this.id = id;
        this.title = title;
        this.filePath = filePath;
        this.name = name;
    }
}