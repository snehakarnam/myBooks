package com.mybooks.app.subscription.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private String productId;

    @ManyToOne
    @JoinColumn(name = "product_group_id", nullable = false)
    private ProductGroupEntity productGroup;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal price;

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

    public String getProductId() {
        return productId;
    }


    public ProductGroupEntity getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(ProductGroupEntity productGroup) {
        this.productGroup = productGroup;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

