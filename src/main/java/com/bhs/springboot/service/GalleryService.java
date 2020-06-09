package com.bhs.springboot.service;

import com.bhs.springboot.domain.Gallery.GalleryEntity;
import com.bhs.springboot.domain.Gallery.GalleryRepository;
import com.bhs.springboot.dto.GalleryDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GalleryService {
    private GalleryRepository galleryRepository;

    //저장하기
    public void savePost(GalleryDto galleryDto)
    {
        galleryRepository.save(galleryDto.toEntity());
    }

    //리스트 보여주기
    public List<GalleryDto> getList() {
        List<GalleryEntity> galleryEntityList = galleryRepository.findAll();
        List<GalleryDto> galleryDtoList = new ArrayList<>();

        for (GalleryEntity galleryEntity : galleryEntityList) {
            galleryDtoList.add(convertEntityToDto(galleryEntity));
        }

        return galleryDtoList;
    }

    private GalleryDto convertEntityToDto(GalleryEntity galleryEntity) {
        return GalleryDto.builder()
                .id(galleryEntity.getId())
                .title(galleryEntity.getTitle())
                .filePath(galleryEntity.getFilePath())
                .name(galleryEntity.getName())
                .build();
    }

    //검색해서 리스트 보여주기
    @Transactional
    public List<GalleryDto> searchPosts(String keyword) {
        List<GalleryEntity> Gallerys = galleryRepository.findAllByTitleContaining(keyword);
        List<GalleryDto> galleryDtoList2 = new ArrayList<>();

        if(Gallerys.isEmpty())
            return galleryDtoList2;

        for(GalleryEntity galleryEntity : Gallerys) {
            galleryDtoList2.add(this.convertEntityToDto(galleryEntity));
        }

        return galleryDtoList2;

    }
}