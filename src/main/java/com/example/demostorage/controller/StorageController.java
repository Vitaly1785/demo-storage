package com.example.demostorage.controller;

import com.example.demostorage.service.ImageService;
import com.example.demostorage.service.StorageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class StorageController {


    private final ImageService imageService;
    private final StorageService service;

    public StorageController(ImageService imageService, StorageService service) {
        this.imageService = imageService;
        this.service = service;
    }

    @GetMapping
    public String fileShow(Model model){
        model.addAttribute("images", imageService.showAll());
        return "/fileShow";
    }

    @GetMapping("/upload")
    public String uploadFile(){
        return "/addImage";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam(value = "file") MultipartFile file) {
        imageService.createImage(file);
        return "redirect:/file";
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
        byte[] data = service.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return new ResponseEntity<>(service.deleteFile(fileName), HttpStatus.OK);
    }

    @GetMapping("/login")
    public String showMyLoginPage(){
        return "/login";
    }
}
