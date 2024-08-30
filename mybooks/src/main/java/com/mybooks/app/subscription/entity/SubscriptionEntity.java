package com.mybooks.app.subscription.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Entity
@Table(name = "subscription")
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "subscription_id")
    private String subscriptionId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private RecurringPlansEntity plan;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private VendorEntity vendor;

    @Column(nullable = false)
    private Boolean autoPay;

    @Column(nullable = false)
    private OffsetDateTime startDate;

    private OffsetDateTime endDate;  // Optional

    @Column(nullable = false)
    private Date nextBillingDate;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt ;

    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    @PreUpdate
    public void updateTimeStamps(){
        updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
    }

    @PrePersist
    public void creationTimeStamps() {
        if (createdAt == null){
            createdAt = OffsetDateTime.now(ZoneOffset.UTC);
            updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
        }
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }



    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public RecurringPlansEntity getPlan() {
        return plan;
    }

    public void setPlan(RecurringPlansEntity plan) {
        this.plan = plan;
    }

    public VendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(VendorEntity vendor) {
        this.vendor = vendor;
    }

    public Boolean getAutoPay() {
        return autoPay;
    }

    public void setAutoPay(Boolean autoPay) {
        this.autoPay = autoPay;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(Date nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }


}

