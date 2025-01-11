package com.silver.productservice.config;

import com.silver.productservice.category.Category;
import com.silver.productservice.enums.Status;
import com.silver.productservice.product.Product;
import com.silver.productservice.product.ProductRepository;
import com.silver.productservice.product.variant.ProductVariant;
import com.silver.productservice.product.variant.ProductVariantRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ProductConfig {
    private final ProductRepository productRepository;
    private final ProductVariantRepository variantRepository;
//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//            List<Product> products = new ArrayList<>();
//            Document doc = Jsoup.connect("https://marc.com.vn/collections/tong-san-pham")
//                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.69 Safari/537.36")
//                    .get();
//            Element containerDiv = doc.selectFirst(".content-product-list");
//
//            if (containerDiv == null) return;
//            Elements productElements = containerDiv.getElementsByClass("col-md-3");
//            for (Element pElement : productElements) {
//                // Lấy tên sản phẩm
//                String productName = doc.selectFirst("div.pro-name > a").text();
//
//                // Lấy URL sản phẩm
//                String productUrl = doc.selectFirst("div.pro-name > a").attr("href");
//
//                // Lấy giá
//                String salePrice = doc.selectFirst("p.pro-price.highlight > span").text();
//                String originalPrice = doc.selectFirst("del.compare-price").text();
//
//                // Lấy hình ảnh chính
//                String imageUrl = doc.selectFirst("div.product-img img.img-loop").attr("src");
//
//                // Lấy thông tin các biến thể (màu sắc)
//                Elements variants = doc.select("div.swatch-element");
//                for (Element variant : variants) {
//                    String color = variant.attr("data-value");
//                    String variantImageUrl = variant.attr("data-img");
//
//                    // In thông tin biến thể
//                    System.out.println("Màu sắc: " + color);
//                    System.out.println("Hình ảnh biến thể: " + variantImageUrl);
//
//                }
//
//                // In thông tin sản phẩm
//                System.out.println("Tên sản phẩm: " + productName);
//                System.out.println("URL sản phẩm: " + productUrl);
//                System.out.println("Giá giảm: " + salePrice);
//                System.out.println("Giá gốc: " + originalPrice);
//                System.out.println("Hình ảnh chính: " + imageUrl);
//            }
//
//            productRepository.saveAll(products);
//        };
//    }



}
