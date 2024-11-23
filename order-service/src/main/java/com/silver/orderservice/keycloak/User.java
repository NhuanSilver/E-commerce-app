package com.silver.orderservice.keycloak;

public record User(
        String sub,
        String name,
        String preferred_username,
        String given_name,
        String family_name,
        String email,
        boolean email_verified) {
}