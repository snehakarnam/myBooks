package com.mybooks.app.subscription.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "product_group")
public class ProductGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_group_id")
    private String productGroupId;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private VendorEntity vendor;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt ;

    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    public String getProductGroupId() {
        return productGroupId;
    }

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



    public VendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(VendorEntity vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
