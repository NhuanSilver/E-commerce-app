package com.silver.productservice.image;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/products/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    @PostMapping
    public List<ImageResponse> uploadImages(@RequestParam("images")List<MultipartFile> images) {
        return imageService.uploadImages(images);
    }
}
