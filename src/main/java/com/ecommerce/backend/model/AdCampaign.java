package com.ecommerce.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "ad_campaigns")
public class AdCampaign {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "store_product_id")
    private StoreProduct storeProduct;

    @Column(name = "budget", nullable = false, precision = 14, scale = 2)
    private BigDecimal budget;

    @ColumnDefault("0")
    @Column(name = "spend", nullable = false, precision = 14, scale = 2)
    private BigDecimal spend;

    @ColumnDefault("0")
    @Column(name = "cpc_base", nullable = false, precision = 10, scale = 4)
    private BigDecimal cpcBase;

    @ColumnDefault("0")
    @Column(name = "competition_malus", nullable = false, precision = 5, scale = 2)
    private BigDecimal competitionMalus;

    @ColumnDefault("0")
    @Column(name = "traffic_generated", nullable = false)
    private Integer trafficGenerated;

    @ColumnDefault("0")
    @Column(name = "conversion_rate", nullable = false, precision = 5, scale = 4)
    private BigDecimal conversionRate;

    @ColumnDefault("'draft'")
    @Column(name = "status", nullable = false, length = Integer.MAX_VALUE)
    private String status;

    @Column(name = "launched_at_real")
    private OffsetDateTime launchedAtReal;

    @Column(name = "finished_at_real")
    private OffsetDateTime finishedAtReal;

    @Column(name = "launched_simulated_day")
    private Integer launchedSimulatedDay;

    @Column(name = "finished_simulated_day")
    private Integer finishedSimulatedDay;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public StoreProduct getStoreProduct() {
        return storeProduct;
    }

    public void setStoreProduct(StoreProduct storeProduct) {
        this.storeProduct = storeProduct;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getSpend() {
        return spend;
    }

    public void setSpend(BigDecimal spend) {
        this.spend = spend;
    }

    public BigDecimal getCpcBase() {
        return cpcBase;
    }

    public void setCpcBase(BigDecimal cpcBase) {
        this.cpcBase = cpcBase;
    }

    public BigDecimal getCompetitionMalus() {
        return competitionMalus;
    }

    public void setCompetitionMalus(BigDecimal competitionMalus) {
        this.competitionMalus = competitionMalus;
    }

    public Integer getTrafficGenerated() {
        return trafficGenerated;
    }

    public void setTrafficGenerated(Integer trafficGenerated) {
        this.trafficGenerated = trafficGenerated;
    }

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getLaunchedAtReal() {
        return launchedAtReal;
    }

    public void setLaunchedAtReal(OffsetDateTime launchedAtReal) {
        this.launchedAtReal = launchedAtReal;
    }

    public OffsetDateTime getFinishedAtReal() {
        return finishedAtReal;
    }

    public void setFinishedAtReal(OffsetDateTime finishedAtReal) {
        this.finishedAtReal = finishedAtReal;
    }

    public Integer getLaunchedSimulatedDay() {
        return launchedSimulatedDay;
    }

    public void setLaunchedSimulatedDay(Integer launchedSimulatedDay) {
        this.launchedSimulatedDay = launchedSimulatedDay;
    }

    public Integer getFinishedSimulatedDay() {
        return finishedSimulatedDay;
    }

    public void setFinishedSimulatedDay(Integer finishedSimulatedDay) {
        this.finishedSimulatedDay = finishedSimulatedDay;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

}