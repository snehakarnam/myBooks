package com.mybooks.app.subscription.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductGroupDto {
    private String groupId;

    @NotBlank(message = "Vendor ID is required.")
    private String vendorId;

    @NotBlank(message = "Group name is required.")
    private String groupName;

}
