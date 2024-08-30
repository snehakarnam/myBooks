package com.mybooks.app.subscription.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public class SubscriptionDto {

    private String subscriptionId;

    @NotBlank(message = "Customer ID is required.")
    private String customerId;

    @NotBlank(message = "Recurring Plan ID is required.")
    private String planId;

    @NotBlank(message = "Vendor ID is required.")
    private String vendorId;

    @NotNull(message = "Auto-pay status is required.")
    private Boolean autoPay;

    private LocalDateTime nextBillingDate;

    private String status;


}
