package com.silver.orderservice.keycloak;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://localhost:8080/realms/ms-keycloak", name = "keycloak")
public interface KeyCloakFeign {
    @GetMapping("/protocol/openid-connect/userinfo")
    User getUserInfo(@RequestHeader("Authorization") String token);
}
