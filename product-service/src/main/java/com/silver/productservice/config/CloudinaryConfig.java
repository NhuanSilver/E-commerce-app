package com.silver.productservice.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary getCloudinary(){
        Map<Object, Object> config = new HashMap<>();
        config.put("cloud_name", "dhtsbzlhw");
        config.put("api_key", "585132772792625");
        config.put("api_secret", "cmErMH7rOXBsED6trje6bmULF4M");
        config.put("secure", true);
        return new Cloudinary(config);
    }

}
