package com.ecommerce.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "campaign_kpis")
public class CampaignKpi {
    @Id
    @ColumnDefault("gen_random_uuid()")
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "campaign_id", nullable = false)
    private AdCampaign campaign;

    @ColumnDefault("0")
    @Column(name = "clicks", nullable = false)
    private Integer clicks;

    @ColumnDefault("0")
    @Column(name = "conversions", nullable = false)
    private Integer conversions;

    @ColumnDefault("0")
    @Column(name = "ctr", nullable = false, precision = 5, scale = 4)
    private BigDecimal ctr;

    @ColumnDefault("0")
    @Column(name = "cpa", nullable = false, precision = 12, scale = 2)
    private BigDecimal cpa;

    @ColumnDefault("0")
    @Column(name = "revenue", nullable = false, precision = 14, scale = 2)
    private BigDecimal revenue;

    @ColumnDefault("0")
    @Column(name = "cost", nullable = false, precision = 14, scale = 2)
    private BigDecimal cost;

    @ColumnDefault("now()")
    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AdCampaign getCampaign() {
        return campaign;
    }

    public void setCampaign(AdCampaign campaign) {
        this.campaign = campaign;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Integer getConversions() {
        return conversions;
    }

    public void setConversions(Integer conversions) {
        this.conversions = conversions;
    }

    public BigDecimal getCtr() {
        return ctr;
    }

    public void setCtr(BigDecimal ctr) {
        this.ctr = ctr;
    }

    public BigDecimal getCpa() {
        return cpa;
    }

    public void setCpa(BigDecimal cpa) {
        this.cpa = cpa;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

}