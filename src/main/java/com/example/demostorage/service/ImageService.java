package com.example.demostorage.service;

import com.example.demostorage.Repo.ImageRepo;
import com.example.demostorage.entity.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    private final ImageRepo imageRepo;
    private final StorageService service;

    public ImageService(ImageRepo imageRepo, StorageService service) {
        this.imageRepo = imageRepo;
        this.service = service;
    }

    public Iterable<Image> showAll(){
        return imageRepo.findAll();
    }

    public Image createImage(MultipartFile file){
        Image createdImage = new Image();
        createdImage.setUrl(service.uploadFile(file));
        imageRepo.save(createdImage);
        return createdImage;
    }
}
