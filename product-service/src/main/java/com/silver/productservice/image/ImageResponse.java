package com.silver.productservice.image;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Builder
public record ImageResponse(UUID id, String imageLink, List<Long> variantIds, Timestamp createdAt, Timestamp updatedAt) {
}
