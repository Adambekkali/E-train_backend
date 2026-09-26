package com.ecommerce.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "stores")
public class Store {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @ColumnDefault("0")
    @Column(name = "treasury", nullable = false, precision = 14, scale = 2)
    private BigDecimal treasury;

    @ColumnDefault("50")
    @Column(name = "brand_reputation", nullable = false, precision = 5, scale = 2)
    private BigDecimal brandReputation;

    @ColumnDefault("1")
    @Column(name = "current_simulated_day", nullable = false)
    private Integer currentSimulatedDay;

    @ColumnDefault("'active'")
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @ColumnDefault("now()")
    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTreasury() {
        return treasury;
    }

    public void setTreasury(BigDecimal treasury) {
        this.treasury = treasury;
    }

    public BigDecimal getBrandReputation() {
        return brandReputation;
    }

    public void setBrandReputation(BigDecimal brandReputation) {
        this.brandReputation = brandReputation;
    }

    public Integer getCurrentSimulatedDay() {
        return currentSimulatedDay;
    }

    public void setCurrentSimulatedDay(Integer currentSimulatedDay) {
        this.currentSimulatedDay = currentSimulatedDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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