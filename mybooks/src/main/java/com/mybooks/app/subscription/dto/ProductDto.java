package com.mybooks.app.subscription.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDto {
    private String productId;

    @NotBlank(message = "Vendor ID is required.")
    private String vendorId;

    @NotBlank(message = "Product name is required.")
    private String productName;

    private String description;

    @NotNull(message = "Price is required.")
    private Double price;

    @Size(min = 3 ,max = 3)
    @NotNull(message = "currencyCode is required.")
    private String currencyCode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
