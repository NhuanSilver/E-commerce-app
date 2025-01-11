package com.silver.productservice.image;

import com.cloudinary.Cloudinary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor

public class ImageService {
    private final Cloudinary cloudinaryService;
    private final ImageRepository imageRepository;
    public List<ImageResponse> uploadImages(List<MultipartFile> imagesFile) {

        Map<Object, Object> params = Map.of("use_filename", true,
                "unique_filename", true,
                "overwrite", true);

        return imagesFile
                .stream()
                .map(imgFile -> {
                    try {
                        UUID imgId = UUID.nameUUIDFromBytes(imgFile.getBytes());

                        if (imageRepository.existsById(imgId)) throw new RuntimeException();


                        String imageLink = (String) cloudinaryService.
                                uploader()
                                .upload(imgFile.getBytes(),
                                        Map.of("public_id", Objects.requireNonNull(Objects.requireNonNull(imgFile.getOriginalFilename())
                                                        .substring(0, imgFile.getOriginalFilename().lastIndexOf("."))),
                                        "unique_filename", true,
                                        "overwrite", true)).get("url");
                        Image image = imageRepository.save(
                                Image.builder().id(imgId).imgLink(imageLink).build());
                        return ImageResponse.builder()
                                .imageLink(imageLink)
                                .id(image.getId())
                                .createdAt(image.getCreateAt())
                                .updatedAt(image.getUpdateAt())
                                .build();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }).toList();
    }
}
