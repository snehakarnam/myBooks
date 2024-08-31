package com.mybooks.app.subscription.dto;

import java.math.BigDecimal;
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
    private BigDecimal price;

    @Size(min = 3 ,max = 3)
    @NotNull(message = "currencyCode is required.")
    private String currencyCode;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public @NotBlank(message = "Vendor ID is required.") String getVendorId() {
        return vendorId;
    }

    public void setVendorId(@NotBlank(message = "Vendor ID is required.") String vendorId) {
        this.vendorId = vendorId;
    }

    public @NotBlank(message = "Product name is required.") String getProductName() {
        return productName;
    }

    public void setProductName(@NotBlank(message = "Product name is required.") String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull(message = "Price is required.") BigDecimal price) {
        this.price = price;
    }

    public @Size(min = 3, max = 3) @NotNull(message = "currencyCode is required.") String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(@Size(min = 3, max = 3) @NotNull(message = "currencyCode is required.") String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
