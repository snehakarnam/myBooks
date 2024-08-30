package com.mybooks.app.subscription.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class RecurringPlanDto {

    private String planId;

    @NotBlank(message = "Product Group ID is required.")
    private String groupId;

    @NotBlank(message = "Vendor ID is required.")
    private String vendorId;

    @NotBlank(message = "Plan name is required.")
    private String planName;

    @NotBlank(message = "Frequency is required.")
    private String frequency;

//    @NotBlank(message = "Billing day is required.")
//    private String billingDay;
    @NotBlank(message = "Billing cycle is required.")
    private String billingCycle;

    @NotNull(message = "Start date is required.")
    private LocalDate startDate;

    private LocalDate endDate;

    @NotNull(message = "Amount is required.")
    private Double amount;

    @Size(min = 3, max =3)
    private String currencyCode;
}
