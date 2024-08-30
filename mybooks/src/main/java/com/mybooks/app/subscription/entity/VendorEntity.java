package com.mybooks.app.subscription.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;



@Entity
@Table(name = "vendor")
public class VendorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vendorId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String phoneNumber;

    private String address;

    @Column(nullable = false)
    private String bankDetails;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt ;

    @Column(nullable = false)
    private OffsetDateTime updatedAt ;

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

    public String getVendorId() {
        return vendorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
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
}
